package co.bohc.diet.domain.common.utils;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.property.ChainedPropertyAccessor;
import org.hibernate.property.PropertyAccessor;
import org.hibernate.property.PropertyAccessorFactory;
import org.hibernate.property.Setter;
import org.hibernate.transform.AliasedTupleSubsetResultTransformer;

/**
 * An specified {@link AliasedTupleSubsetResultTransformer} to process the
 * following case:
 * 
 * database table field name: nick_name object property name : nickName
 * 
 * 
 * @author unicorn(haiyin-ma) 2014-12-31
 */
public final class ColumnNameToCamelBeanResultTransformer extends AliasedTupleSubsetResultTransformer {

    private static final long serialVersionUID = -2093678308937189074L;
    
    private final Class<?> resultClass;
    private boolean isInitialized;
    private String[] aliases;
    private Setter[] setters;

    public ColumnNameToCamelBeanResultTransformer(Class<?> resultClass) {
        if (resultClass == null) {
            throw new IllegalArgumentException("resultClass cannot be null");
        }
        isInitialized = false;
        this.resultClass = resultClass;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isTransformedValueATupleElement(String[] aliases, int tupleLength) {
        return false;
    }

    public Object transformTuple(Object[] tuple, String[] aliases) {
        Object result;

        try {
            if (!isInitialized) {
                initialize(aliases);
            } else {
                check(aliases);
            }

            result = resultClass.newInstance();

            for (int i = 0; i < aliases.length; i++) {
                if (setters[i] != null) {
                    setters[i].set(result, tuple[i], null);
                }
            }
        } catch (InstantiationException e) {
            throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName());
        } catch (IllegalAccessException e) {
            throw new HibernateException("Could not instantiate resultclass: " + resultClass.getName());
        }

        return result;
    }

    private void initialize(String[] aliases) {
        PropertyAccessor propertyAccessor = new ChainedPropertyAccessor(new PropertyAccessor[] {
                PropertyAccessorFactory.getPropertyAccessor(resultClass, null),
                PropertyAccessorFactory.getPropertyAccessor("field") });
        this.aliases = new String[aliases.length];
        setters = new Setter[aliases.length];
        for (int i = 0; i < aliases.length; i++) {
            String alias = aliases[i];
            if (alias != null) {
                this.aliases[i] = alias;
                setters[i] = propertyAccessor.getSetter(resultClass, transformAliases(alias));
            }
        }
        isInitialized = true;
    }
    
    private static String transformAliases(String aliases) {
        if (!aliases.contains("_")) {
            return aliases;
        }
        
        StringBuilder sb = new StringBuilder();
        String[] parts = aliases.split("_");
        for (int i = 0; i < parts.length; i++) {
            String item = (i == 0) ? parts[i] : StringUtils.capitalize(parts[i]);
            sb.append(item);
        }
        return sb.toString();
    }

    private void check(String[] aliases) {
        if (!Arrays.equals(aliases, this.aliases)) {
            throw new IllegalStateException("aliases are different from what is cached; aliases="
                    + Arrays.asList(aliases) + " cached=" + Arrays.asList(this.aliases));
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ColumnNameToCamelBeanResultTransformer that = (ColumnNameToCamelBeanResultTransformer) o;

        if (!resultClass.equals(that.resultClass)) {
            return false;
        }
        if (!Arrays.equals(aliases, that.aliases)) {
            return false;
        }

        return true;
    }

    public int hashCode() {
        int result = resultClass.hashCode();
        result = 31 * result + (aliases != null ? Arrays.hashCode(aliases) : 0);
        return result;
    }
}

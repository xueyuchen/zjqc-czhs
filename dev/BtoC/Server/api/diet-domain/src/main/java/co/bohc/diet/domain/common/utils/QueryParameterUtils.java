package co.bohc.diet.domain.common.utils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.commons.beanutils.BeanMap;
import org.hibernate.SQLQuery;

public class QueryParameterUtils {

    public static void copyParametersExclude(SQLQuery query, Object parameters,String ...excludeProperties) {
        Map<String, ?> map = dealParameters(parameters);
        if (excludeProperties!=null){
            for (String property : excludeProperties) {
                map.remove(property);
            }
        }
        copyParameters(query, map);
    }
    
    
	public static void copyParameters(SQLQuery query, Object parameters) {
		
		Map<String, ?> map = dealParameters(parameters);
		
		if (map != null) {
			for (Map.Entry<String, ?> entry : map.entrySet()) {
				
				Object value = entry.getValue();
				if ( value instanceof Collection ) {
					query.setParameterList(entry.getKey(), (Collection<?>)value );
				}else if(entry.getValue() != null && !entry.getValue().equals("")){
					query.setParameter(entry.getKey(), value);
				}
			}
		}

	}
	
	public static void copyParameters(Query query, Object parameters) {
		
		Map<String, ?> map = dealParameters(parameters);
		
		if (map != null) {
			for (Map.Entry<String, ?> entry : map.entrySet()) {
				if(entry.getValue() != null && !entry.getValue().equals("")){
					query.setParameter(entry.getKey(), entry.getValue());
				}
			}
		}
	}
	
	
	public static void copyParameters(TypedQuery<?> query, Object parameters) {
		
		Map<String, ?> map = dealParameters(parameters);
		
		if (map != null) {
			for (Map.Entry<String, ?> entry : map.entrySet()) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}

	}

	@SuppressWarnings("unchecked")
	private static Map<String, Object> dealParameters(Object parameters) {
		Map<String, Object> map = null;
		if ( parameters instanceof Map) {
			map = (Map<String, Object>)parameters;
			
		} else {
			
				BeanMap beanMap = new BeanMap(parameters);
				map=new HashMap<String, Object>();
				for(Object key: beanMap.keySet()){
				    if((key instanceof String )&&!key.equals("class")){
				        Object value=beanMap.get(key);
				        if ((value!=null)) {
				            map.put((String)key, value);
                        }
				    }
				}

		}
		
		if (map != null){
			map.remove("class");
		}
		return map;
	}
}

package co.bohc.diet.domain.common.utils;

import java.util.Collection;
import java.util.List;

import org.dozer.Mapper;

import com.google.common.collect.Lists;

public final class BeanMapperUtils {

    private BeanMapperUtils() {
    }

    /**
     * @param mapper
     * @param sourceList
     * @param destinationClass
     * @return
     * @author LiuYifan
     */
    public static <T> List<T> mapList(Mapper mapper, Collection<?> sourceList, Class<T> destinationClass) {
        List<T> destinationList = Lists.newArrayList();
        if (mapper != null) {
            for (Object sourceObject : sourceList) {
                T destinationObject = mapper.map(sourceObject, destinationClass);
                destinationList.add(destinationObject);
            }
        }
        return destinationList;
    }

    /**
     * Convert object type.
     */
    public static <T> T map(Mapper mapper, Object source, Class<T> destinationClass) {
        if (mapper != null) {
            return mapper.map(source, destinationClass);
        }
        return null;
    }

    /**
     * Copy the value from A to B.
     */
    public static void copy(Mapper mapper, Object source, Object destinationObject) {
        if (mapper != null) {
            mapper.map(source, destinationObject);
        }
    }

    /**
     * 
     * @param mapper
     * @param sourceList
     * @param destinationClass
     * @return
     * @author CXY creDt: 2015年1月16日 上午11:08:29
     */
    public static <T> List<T> mapListCanNull(Mapper mapper, Collection<?> sourceList, Class<T> destinationClass) {
        if(sourceList == null){
            return null;
        }
        List<T> destinationList = Lists.newArrayList();
        if (mapper != null) {
            for (Object sourceObject : sourceList) {
                T destinationObject = null;
                if (sourceObject != null) {
                    destinationObject = mapper.map(sourceObject, destinationClass);
                }
                destinationList.add(destinationObject);
            }
        }
        return destinationList;
    }

    public static <T> T mapCanNull(Mapper mapper, Object source, Class<T> destinationClass) {
        if (mapper != null) {
            if (source == null) {
                return null;
            } else {
                return mapper.map(source, destinationClass);
            }
        }
        return null;
    }
}

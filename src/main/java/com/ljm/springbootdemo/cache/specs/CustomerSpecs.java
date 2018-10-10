package com.ljm.springbootdemo.cache.specs;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import static com.google.common.collect.Iterables.toArray;

//自定义Repository实现
public class CustomerSpecs {

    //定义一个返回值为Secification的方法
    public static <T> Specification<T> byAuto(final EntityManager entityManager, final T example){
        //获取当前实体类对象类的类型
        final Class<T> type = (Class<T>) example.getClass();
        return new Specification<T>() {
            @Override
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //新建Predicate 列表 存储构造的查询条件
                List<Predicate> predicates = new ArrayList<>();
                //获取实体类的EntityType ，从中获得实体类的属性
                EntityType<T> entity = entityManager.getMetamodel().entity(type);

                //对实体类的属性进行循环
                for(Attribute<T,?> attr: entity.getDeclaredAttributes()){
                    //获取实体类对象的某一个属性的值
                   Object attrValue = getValue(example,attr);
                   if(attrValue !=null){
                       //当前属性值为字符型时
                       if(attr.getJavaType() ==String.class){
                           //当前字符不为空时
                           if(!StringUtils.isEmpty(attrValue)){
                               //构造当前属性like 属性值查询条件并添加到条件列表里
                               predicates.add(criteriaBuilder.like(root.get(attribute(entity,attr.getName(),String.class)),
                                       pattern((String) attrValue))); //构造equal查询条件，并添加到条件列表中
                           }else{
                              //其余情况，构造属性和属性值equal查询条件，并添加到条件列表中
                               predicates.add(criteriaBuilder.equal(root.get(attribute(entity,attr.getName(),attrValue.getClass())),attrValue));
                           }
                       }
                   }
                }
                //将条件列表转换成Predicate
                return predicates.isEmpty()?criteriaBuilder.conjunction():criteriaBuilder.and(toArray(predicates,Predicate.class));
            }
        };
    }

    /**
     *构造like的查询模式
     * @param attrValue
     * @return
     */
    private static String pattern(String attrValue) {
        return "%" + attrValue + "%";
    }

    /**
     * 获得实体类的当前属性的SingularAttribute ,singularattribute包含的是实体类的某个单独属性
     * @param entity
     * @param name
     * @param aClass
     * @param <E>
     * @param <T>
     * @return
     */
    private static <E,T> SingularAttribute<T,E> attribute(EntityType<T> entity, String name, Class<E> aClass) {
                return entity.getDeclaredSingularAttribute(name,aClass);
    }

    /**
     * 通过反射获取对象具体属性的值
     * @param example
     * @param attr
     * @param <T>
     * @return
     */
    private static <T> Object getValue(T example, Attribute<T, ?> attr) {
        return ReflectionUtils.getField((Field) attr.getJavaMember(),example);
    }
}

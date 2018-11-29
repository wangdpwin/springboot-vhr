package com.study.annotations;

import com.study.annotations.anno.Colum;
import com.study.annotations.anno.Primary;
import com.study.annotations.anno.Table;
import com.study.annotations.bean.User;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class AnnotationDemo {

  public static void main(String[] args) throws Exception {
      User user = new User(UUID.randomUUID().toString(),"test",22,new Date());
      String insertSql = prepareSql(user);
      System.out.println(insertSql);
  }

  private static String prepareSql(User user) throws IllegalAccessException {
      Class<User> c = User.class;
      Field[] fields = c.getDeclaredFields();
      StringBuilder builder = new StringBuilder("insert into ");
      if(c.getAnnotation(Table.class)!=null){
          builder.append(c.getAnnotation(Table.class).name()).append(" ");
      }
      List<Object> values = new ArrayList<Object>();
      for (Field f : fields){
          f.setAccessible(true);
          Primary primary = f.getAnnotation(Primary.class);
          Object obj = f.get(user);
          Colum colum = f.getAnnotation(Colum.class);
          if(colum.value()!=null){
              if(primary!=null && primary.pk()){
                  System.out.println(colum.value() + " is pk ");
              }
              if(obj!=null){
                  builder.append(colum.value()).append(",");
                  values.add(obj);
              }
          }else{
              System.out.println(f.toString() + " is null ");
          }
      }
      builder.deleteCharAt(builder.length()-1).append(" values(");
      for(Object obj:values){
          if(obj instanceof String){
              builder.append("'").append(obj.toString()).append("'").append(",");
          }else if(obj instanceof Date){
              Date date =(Date)obj;
              builder.append("'").append(date.toLocaleString()).append("'").append(",");
          }else{
              builder.append(obj.toString()).append(",");
          }
      }
      builder.deleteCharAt(builder.length()-1).append(")");
      return builder.toString();
  }


}

package results;

/***/
public class ObjectClassAdapter extends test.TargetClass {

 /***/
 private test.ObjectClass m_objectClass;

 /***/
 public ObjectClassAdapter(test.ObjectClass obj)
 {
  m_objectClass = obj;
 }

 /***/
 public void addValue(test.ValueTargetClass arg0)
 {
 }

 /***/
 public void removeValue()
 {
 }

 /***/
 public java.lang.String getName()
 {
  return m_objectClass.getName();
 }

 /***/
 public java.util.List getValues()
 {
  return m_objectClass.getValues();
 }

 /***/
 public boolean equals(java.lang.Object arg0)
 {
  return m_objectClass.equals(arg0);
 }

 /***/
 public java.lang.String toString()
 {
  return m_objectClass.toString();
 }

}
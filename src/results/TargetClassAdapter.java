package results;

/***/
public class TargetClassAdapter extends test.ObjectClass {

 /***/
 private test.TargetClass m_targetClass;

 /***/
 public TargetClassAdapter(test.TargetClass obj)
 {
  m_targetClass = obj;
 }

 /***/
 public void addValue(test.ValueObjectClass arg0)
 {
 }

 /***/
 public java.lang.String getName()
 {
  return m_targetClass.getName();
 }

 /***/
 public java.util.List getValues()
 {
  return m_targetClass.getValues();
 }

 /***/
 public boolean equals(java.lang.Object arg0)
 {
  return m_targetClass.equals(arg0);
 }

 /***/
 public java.lang.String toString()
 {
  return m_targetClass.toString();
 }

}
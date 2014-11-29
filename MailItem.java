
/**
 * Write a description of class MailItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailItem
{
    /**
     * declaramos los atributos que necesitamos dentro de la clase, en este caso
     * todos del tipo String que guardarán la información correspondiente a cada
     * email enviado.
     */
   private String from;
   private String to;
   private String subject;
   private String message;
   
   /**
    * En el constructor damos valor a todos los atributos por medio de parametros,
    * para conseguir un código mas claro nombramos igual los parametros que los 
    * atributos para que sea mas facil relacionarlos.
    */
   public MailItem( String from , String to , String subject , String message ){
       this.from = from;
       this.to = to;
       this.subject = subject;
       this.message = message;
    }
    /**
     * Hacemos todos los metodos Getter que nos permiten retornar toda la 
     * información para poderla obtener desde otras clases.
     */
   public String getFrom(){
        return from;
   }
   public String getTo(){
       return to;
    }
   public String getSubject(){
       return subject;
    }
   public String getMessage(){
       return message;
    }
    /**
     * Método que nos imprimirá por pantalla el contenido del email.
     */
   public void print(){
       System.out.println("from: " + from + "\n subject: " + subject + "\n Message: "
                           + message);
    }
}

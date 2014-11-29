
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    private MailServer server;
    private String user;
    
    public MailClient(MailServer server, String user){
        this.server = server;
        this.user = user;
    }
    /**
     * Metodo que obtiene el ultimo mensaje que halla para el usuario del cliente y
     * lo retorna.
     * El email se borra del servidor y el método no lo guarda
     */
    public MailItem getNextMailItem(){
        MailItem email = server.getNextMailItem(user);
        return email;
    }
    /**
     * Imprime el último mensaje del servidor mediante el metodo local 
     * getNextMailItem y lo imprime por pantalla mediante el metodo de MailItem
     * print.
     * Si no hay mensajes en el servidor, avisa de ello.
     */
    public void printNextMailItem(){
        MailItem email = getNextMailItem();
        if(email != null){
            email.print();
        }
        else{
            System.out.println("No hay mensajes pendientes");
        }
    }
    /**
     * Envia un email a otro usuario
     */
    public void sendMailItem(String to, String subject, String message){
        MailItem email = new MailItem(user, to, subject, message);
        server.post(email);
    }
    /**
     * método que responderá automaticamente los mensajes contestando que estamos
     * de vacaciones
     */
    public void getNextMailItemAndAutorespond(){
        //Creamos una variable local donde guardar nuestro email y guardamos
        //En ella el último email del servidor
        MailItem email = getNextMailItem();
        //Comprobamos que hubiese algún email y en caso afirmativo lo procesamos
        if(email != null){
            //Para ello nos creamos dos variables locales donde poder guardar
            //La información y cambiarla
            String subject = "RE: " + email.getSubject();
            String message = "Estoy de vacaciones \n" + email.getMessage();
            
            //Enviamos el email al que nos lo envio
            sendMailItem(email.getFrom(), subject, message);
        }
    }
}

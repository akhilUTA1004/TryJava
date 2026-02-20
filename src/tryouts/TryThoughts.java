package tryouts;

public class TryThoughts {
    /*
     *
     * Print the domain of an email address
     * Example: For the email "
     * Output: Domain: hotmail.com
     *
     * */
    public static void printEmailDomain(String email) {
        System.out.println("Email : " + email);
        int atIndex = email.indexOf('@');
        if (atIndex != -1 && atIndex < email.length() - 1) {
            String domain = email.substring(atIndex + 1);
            System.out.println("Email Domain : " + domain);
        } else {
            System.out.println("Invalid email address.");
        }
    }

    /*
     *
     * Print the host name of an email address
     * Example: For the email "abc.def.cgf.hotmail.in"
     * Output: Host name: abc.def.cgf.hotmail
     *
     * */
    public static void printEmailHostName(String email) {
        int at = email.lastIndexOf('@');
        if (at < 0 || at == email.length() - 1) {
            System.out.println("Invalid email address.");
            return;
        }

        String host = email.substring(at + 1);          // e.g. abc.def.cgf.hotmail.in
        int lastDot = host.lastIndexOf('.');
        if (lastDot <= 0 || lastDot == host.length() - 1) {
            System.out.println("Invalid email address.");
            return;
        }
        System.out.println("Email : " + email);
        System.out.println("Email Host name : " + host.substring(0, lastDot)); // e.g. abc.def.cgf.hotmail
    }


}

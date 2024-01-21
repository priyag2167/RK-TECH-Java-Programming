import java.util.Random;

public class generate {
  public static  final String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   public static  final String lowercase = "abcdefghijklmnopqrstuvwxyz";
    public static final String num = "1234567890";
    public static final String specialchar = "!@#$%^7*()+{}?//|[]<>";

    private final Random random;

    public generate(){
         random = new Random();
    }

    public String generatepassword(int length,boolean includeupper,boolean includelower, boolean includenumber,
                                   boolean includespecial){

        StringBuilder builder=new StringBuilder();
        String validcharacter=" ";
        if(includeupper) validcharacter+=uppercase;
        if(includelower) validcharacter+=lowercase;
        if(includenumber) validcharacter+=num;
        if(includespecial) validcharacter+=specialchar;

        for(int i=0;i<length;i++){
            int randomindex= random.nextInt(validcharacter.length());
            char randomchar=validcharacter.charAt(randomindex);
            builder.append(randomchar);
        }
        return builder.toString();
    }
}

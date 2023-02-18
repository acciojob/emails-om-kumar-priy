package com.driver;

public class Email {

    private String emailId;
    private String password;

    public Email(String emailId){
        this.emailId = emailId;
        this.password = "Accio@123";
    }

    public String getEmailId() {
        return emailId;
    }

    public String getPassword() {
        return password;
    }

    public void changePassword(String oldPassword, String newPassword){
        //Change password only if the oldPassword is equal to current password and the new password meets all of the following:

        // 1. It contains at least 8 characters
        // 2. It contains at least one uppercase letter

        // 3. It contains at least one lowercase letter
        // 4. It contains at least one digit
        // 5. It contains at least one special character. Any character apart from alphabets and digits is a special character
        if (password == oldPassword)
        {
            int n=newPassword.length();
            if(n>=8)
            {
                int uppercase=0,lowercase=0,digit=0,special=0;
              for(int i=0;i<n;i++)
              {
                  int a=(int)newPassword.charAt(i);
                  if(a>64 && a<91)
                  uppercase=1;
                 else if(a>96 && a<123)
                   lowercase=1;
                  else  if(a>47 && a<58)
                  digit=1;
                  else
                    special=1;
              }
              if(uppercase==1 && lowercase==1 && digit==1 && special==1)
              {
                  password=newPassword;
              }
            }
        }

    }
}

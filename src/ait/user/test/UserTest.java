package ait.user.test;

import ait.user.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;
    final String email="peter@gmx.de";
    final String password="1234De!fff";

        @BeforeEach
    void setUp() {
        user = new User(email, password);
    }
    @Test
    void testValidEmail(){
        String validEmail="peter123@gmx.de";
        user.setEmail(validEmail);
        assertEquals(validEmail,user.getEmail());
    }
    @Test
    void testEmailDog(){
        String InvalidEmail="peter123.gmx.de";
        user.setEmail(InvalidEmail);
        assertEquals(email,user.getEmail());
    }
    @Test
    void testEmailDortAfterDog(){
        String InvalidEmail="peter123@gmx,de";
        user.setEmail(InvalidEmail);
        assertEquals(email,user.getEmail());
    }
    @Test
    void testEmailSimbolAfterDort(){
        String InvalidEmail="peter123@gmx.";
        user.setEmail(InvalidEmail);
        assertEquals(email,user.getEmail());
    }
    @Test
    void testEmailSymbolAlphaAndDigit(){
        String InvalidEmail="peter123>@gmx.de";
        user.setEmail(InvalidEmail);
        assertEquals(email,user.getEmail());
    }



    @Test
    void testValidPassword(){
         String validPassword="qwertyA1!";
         user.setPassword(validPassword);
         assertEquals(validPassword,user.getPassword());
    }
    @Test
    void testPasswordLength(){
           String inValidPassword="qwerB7!";
           user.setPassword(inValidPassword);
           assertEquals(password, user.getPassword());
    }
    @Test
    void testPasswordUpperCase(){
        String inValidPassword="qweqrbb7!";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testPasswordLowerCase(){
        String inValidPassword="YYYYYY7!";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testPasswordDigit(){
        String inValidPassword="qwerbeE!";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }
    @Test
    void testPasswordSpecialSymbol(){
        String inValidPassword="qwerbb7t";
        user.setPassword(inValidPassword);
        assertEquals(password, user.getPassword());
    }

}
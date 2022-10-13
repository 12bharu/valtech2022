package com.valtech.training.Valtech.junit5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;


public class ArthmaticTest {
	private Arthmatic arthmatic;
	private static int ZERO;
	
	@Nested
    public  class DivisionTest {
        
        private Arthmatic arthmatic;
        @Test
        public void testDivByZero(){
           arthmatic= new Arthmaticimpl();
           assertThrows(ArithmeticException.class,() -> { arthmatic.div(2,ZERO);});
        }
    }
	
	@Nested
    @DisplayName("this is for testing sub methord of the arthmaetic")
    public  class SubTest{
        
        private Arthmatic arthmatic;
        
        @ParameterizedTest
        @CsvSource({
            "'Subtracting 2 positive Nos',2,3,-1",
            "'Subtracting 2 negative Nos',-2,-3,1",
            "'Subtracting 1 negative 1 positive Nos',-2,3,-5"
        })
        public void testsub(String name,int a,int b,int res){
            arthmatic=new Arthmaticimpl();
            assertEquals(res, arthmatic.sub(a, b));
        }
        
    }
	
	
	
	@ParameterizedTest
	@DisplayName(value="{index} Testing for add with {0} and 0")
	@CsvSource({
		"'Adding 2 positive numberds',2,3,5",
		"'Adding 2 negative numbers',-2,-3,-5",
		"'Adding 1 positive 1 negative numbers',-2,3,1"
	})
	public void testAdd(String name,int a,int b,int res){
		assertEquals(res, arthmatic.add(a, b));
		
	}
	public static Stream<Arguments> argumnetsForAdd(){
		return Stream.of(Arguments.of(2,3,5),Arguments.of(1,3,4));
		
	}
	@ParameterizedTest
    @MethodSource("argumnetsForAdd")
    public void testAdd(int a,int b,int res){
        
    }
	
	@ParameterizedTest
	@ValueSource(ints={2,3,4,-1,-2})
	@DisplayName(value="{index} Testing for add with {0} and 0")
	public void testAdd(int a){
		assertEquals(a, arthmatic.add(a, ZERO));
	}
	@Test
	@DisplayName("generic Test cases for add ...")
	public void testAdd(){
		assertEquals(5, arthmatic.add(2, 3));
		assertEquals(5, arthmatic.add(3, 2));
	}
	
	@BeforeAll
	public static void executeMefirst(){
		System.out.println("Before All-Executed project");
		ZERO=0;
	}
	@AfterAll
	public static void executeMelast(){
		System.out.println("After All-Executed project");
		
	}
	@BeforeEach 
	public void runBeforeTest() {
		arthmatic = new Arthmaticimpl();
		System.out.println("run before");
		
	}
	@AfterEach
	public void afterTest(){
		System.out.println("after each method");
	}
	
	
	@Test
	public void testhello() {
		System.out.println("hlo...");
	}
	
	@Test
	private void testHii() {
		System.out.println("Hiii");

	}

}

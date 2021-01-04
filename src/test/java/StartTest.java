import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class StartTest {
    
    @Test
    public void testCheckWinHorizontPositive() {
        
        char[][] map = new char[3][3];
        map[0][0] = Start.DOT_X;
        map[0][1] = Start.DOT_X;
        map[0][2] = Start.DOT_X;
        Start.setMapTest(map);
        assertTrue("we are waiting true", Start.checkWin(Start.DOT_X));
    }
    
    @Test
    public void testCheckWinHorizontNegative() {
        
        char[][] map1 = new char[3][3];
        map1[0][0] = Start.DOT_X;
        map1[0][1] = Start.DOT_O;
        map1[0][2] = Start.DOT_X;
        Start.setMapTest(map1);
        assertFalse("we are waiting false", Start.checkWin(Start.DOT_X));
        
    }
    
    @Test
    public void testCheckWinHorizontPozitiveThree() {
        
        char[][] map = new char[3][3];
        map[2][0] = Start.DOT_X;
        map[2][1] = Start.DOT_X;
        map[2][2] = Start.DOT_X;
        Start.setMapTest(map);
        assertTrue("we are waiting true", Start.checkWin(Start.DOT_X));
        
    }
    
    @Test
    public void testCheckWinVerticalPositive() {
        
        char[][] map = new char[3][3];
        map[0][0] = Start.DOT_X;
        map[1][0] = Start.DOT_X;
        map[2][0] = Start.DOT_X;
        Start.setMapTest(map);
        assertTrue("we are waiting true", Start.checkWin(Start.DOT_X));
    }
    
    @Test
    public void testCheckWinVerticalNegative() {
        
        char[][] map1 = new char[3][3];
        map1[0][0] = Start.DOT_X;
        map1[1][0] = Start.DOT_O;
        map1[2][0] = Start.DOT_X;
        Start.setMapTest(map1);
        assertFalse("we are waiting false", Start.checkWin(Start.DOT_X));
        
    }
    
    @Test
    public void testCheckWinVerticalPozitiveThree() {
        
        char[][] map = new char[3][3];
        map[0][2] = Start.DOT_X;
        map[1][2] = Start.DOT_X;
        map[2][2] = Start.DOT_X;
        Start.setMapTest(map);
        assertTrue("we are waiting true", Start.checkWin(Start.DOT_X));
        
    }
    
    @Test
    public void testCheckWinisDiagonalOneWinPozitive() {
        
        char[][] map = new char[3][3];
        map[0][0] = Start.DOT_X;
        map[1][1] = Start.DOT_X;
        map[2][2] = Start.DOT_X;
        Start.setMapTest(map);
        assertTrue("we are waiting true", Start.checkWin(Start.DOT_X));
        
    }
    
    @Test
    public void testCheckWinisDiagonalOneWinNegative() {
        
        char[][] map = new char[3][3];
        map[0][0] = Start.DOT_X;
        map[1][1] = Start.DOT_O;
        map[2][2] = Start.DOT_X;
        Start.setMapTest(map);
        assertFalse("we are waiting false", Start.checkWin(Start.DOT_X));
    }
    
    @Test
    public void testCheckWinisDiagonalTwoWinPositive() {
        
        char[][] map = new char[3][3];
        map[0][2] = Start.DOT_X;
        map[1][1] = Start.DOT_X;
        map[2][0] = Start.DOT_X;
        Start.setMapTest(map);
        assertTrue("we are waiting true", Start.checkWin(Start.DOT_X));
    }
    
}

package template;

import org.junit.Test;

import static org.junit.Assert.*;

public class RobotTest {

    @Test
    public void simulateArm() {
        Rack rack = new Rack(5, 10);
        Robot robot = new RoboticArm(-1, rack);

        String expectedOutput = "{A=[foo], B=[Foo, World], C=[], D=[bar, hello], E=[]}";
        String actualOutput = robot.simulateArm("FD{foo}FFD{bar}RFFD{Foo}RFFD{World}D{}DA{hello}").toString();
        assertEquals(expectedOutput, actualOutput);
    }
}
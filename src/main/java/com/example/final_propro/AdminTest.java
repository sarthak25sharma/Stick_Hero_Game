package com.example.final_propro;

import org.testng.annotations.Test;

import static org.junit.Assert.assertNull;
import static org.testng.Assert.*;

public class AdminTest{
    @Test
    public void atest(){
        Admin a= Admin.getInstance();
        assertNotNull(a);
    }
    @Test
    public void stickHerotest(){
        StickHero sh = StickHero.getInstance();
        assertNotNull(sh);
    }

    @Test
    public void testCounterThread() {
        int thread_counted=HelloController.move_count;
        int manual_count=HelloController.count;
        assertEquals(thread_counted,manual_count);
    }




}

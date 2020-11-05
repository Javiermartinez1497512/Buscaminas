package Buscaminas;


import static org.junit.Assert.*;

import org.junit.Test;


public class RNGTest {
	
	@Test
	public void getRandomNumber_MockRNG_Test() {
		
		RNG mRNG= new MockRNG();
		mRNG.setConfig(0);
		
		int[] v = mRNG.getRandomNumber();
		int[] res_1 = {0,0};
		assertEquals(v[0], res_1[0]);
		assertEquals(v[1], res_1[1]);

		v = mRNG.getRandomNumber();
		int [] res_2 = {0,1};
		assertEquals(v[0], res_2[0]);
		assertEquals(v[1], res_2[1]);
		
		v = mRNG.getRandomNumber();
		int [] res_3 = {1,7};
		assertEquals(v[0], res_3[0]);
		assertEquals(v[1], res_3[1]);
		
		v = mRNG.getRandomNumber();
		int [] res_4 = {0,7};
		assertEquals(v[0], res_4[0]);
		assertEquals(v[1], res_4[1]);
		
		v = mRNG.getRandomNumber();
		int [] res_5 = {7,0};
		assertEquals(v[0], res_5[0]);
		assertEquals(v[1], res_5[1]);
		
		v = mRNG.getRandomNumber();
		int [] res_6 = {7,1};
		assertEquals(v[0], res_6[0]);
		assertEquals(v[1], res_6[1]);
		
		v = mRNG.getRandomNumber();
		int [] res_7 = {6,7};
		assertEquals(v[0], res_7[0]);
		assertEquals(v[1], res_7[1]);
		
		v = mRNG.getRandomNumber();
		int [] res_8 = {7,7};
		assertEquals(v[0], res_8[0]);
		assertEquals(v[1], res_8[1]);
	}
	
	@Test
	public void getRandomNumber_MockRNG_2_Test() {
		RNG mRNG2= new MockRNG_2();
		mRNG2.setConfig(0);
		
		int [] v = mRNG2.getRandomNumber();
		int[] res_9 = {0,1};
		assertEquals(v[0], res_9[0]);
		assertEquals(v[1], res_9[1]);

		v = mRNG2.getRandomNumber();
		int [] res_10 = {0,6};
		
		System.out.println(v[0]);
		System.out.println(v[1]);
		
		assertEquals(v[0], res_10[0]);
		assertEquals(v[1], res_10[1]);
		
		v = mRNG2.getRandomNumber();
		int [] res_11 = {1,0};
		assertEquals(v[0], res_11[0]);
		assertEquals(v[1], res_11[1]);
		
		v = mRNG2.getRandomNumber();
		int [] res_12 = {2,6};
		assertEquals(v[0], res_12[0]);
		assertEquals(v[1], res_12[1]);
		
		v = mRNG2.getRandomNumber();
		int [] res_13 = {3,3};
		assertEquals(v[0], res_13[0]);
		assertEquals(v[1], res_13[1]);
		
		v = mRNG2.getRandomNumber();
		int [] res_14 = {5,6};
		assertEquals(v[0], res_14[0]);
		assertEquals(v[1], res_14[1]);
		
		v = mRNG2.getRandomNumber();
		int [] res_15 = {6,2};
		assertEquals(v[0], res_15[0]);
		assertEquals(v[1], res_15[1]);
		
		v = mRNG2.getRandomNumber();
		int [] res_16 = {7,4};
		assertEquals(v[0], res_16[0]);
		assertEquals(v[1], res_16[1]);
	}
	
	@Test
	public void getRandomNumber_AleatorioRNG_Test() {
		RNG RNG= new AleatorioRNG();
		
		int v [] = RNG.getRandomNumber();
		boolean res_1 =false;
		if (v[0] >= 0 && v[0] < 8 && v[1] >= 0 && v[1] < 8) {
			res_1 = true;
		}
		assertTrue(res_1);
		
		v = RNG.getRandomNumber();
		boolean res_2 =false;
		if (v[0] >= 0 && v[0] < 8 && v[1] >= 0 && v[1] < 8) {
			res_2 = true;
		}
		assertTrue(res_2);
		
		v = RNG.getRandomNumber();
		boolean res_3 =false;
		if (v[0] >= 0 && v[0] < 8 && v[1] >= 0 && v[1] < 8) {
			res_3 = true;
		}
		assertTrue(res_3);
		
		v = RNG.getRandomNumber();
		boolean res_4 =false;
		if (v[0] >= 0 && v[0] < 8 && v[1] >= 0 && v[1] < 8) {
			res_4 = true;
		}
		assertTrue(res_4);
		
		v = RNG.getRandomNumber();
		boolean res_5 =false;
		if (v[0] >= 0 && v[0] < 8 && v[1] >= 0 && v[1] < 8) {
			res_5 = true;
		}
		assertTrue(res_5);
		
		v = RNG.getRandomNumber();
		boolean res_6 =false;
		if (v[0] >= 0 && v[0] < 8 && v[1] >= 0 && v[1] < 8) {
			res_6 = true;
		}
		assertTrue(res_6);
		
		v = RNG.getRandomNumber();
		boolean res_7 =false;
		if (v[0] >= 0 && v[0] < 8 && v[1] >= 0 && v[1] < 8) {
			res_7 = true;
		}
		assertTrue(res_7);
		
		v = RNG.getRandomNumber();
		boolean res_8 =false;
		if (v[0] >= 0 && v[0] < 8 && v[1] >= 0 && v[1] < 8) {
			res_8 = true;
		}
		assertTrue(res_8);
		
		
	}
	
	
}

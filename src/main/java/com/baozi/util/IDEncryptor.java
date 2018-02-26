package com.baozi.util;

public class IDEncryptor {

	private static String pass;

	public static IDEncryptor getInstance(){
		int newPass=getPassFromDB();
		return new IDEncryptor(newPass);		
	}
	
	private static int getPassFromDB(){
		return DEFAULT_KEY;
	}
	
    private final static int DEFAULT_KEY = 0x6CFB18E2;

    private final static int LOW_16_MASK = 0xFFFF;
    private final static int HALF_SHIFT = 16;
    private final static int NUM_ROUNDS = 4;

    private int mKey;

    private int[] mRoundKeys = new int[NUM_ROUNDS];

    private IDEncryptor() { this(DEFAULT_KEY); }

    private IDEncryptor(int key) { setKey(key); }

    /** Sets a new value for the key and key schedule. */
    private void setKey(int newKey) {
        assert (NUM_ROUNDS == 4) : "NUM_ROUNDS is not 4";
        mKey = newKey;

        mRoundKeys[0] = mKey & LOW_16_MASK;
        mRoundKeys[1] = ~(mKey & LOW_16_MASK);
        mRoundKeys[2] = mKey >>> HALF_SHIFT;
        mRoundKeys[3] = ~(mKey >>> HALF_SHIFT);
    }

	private int getKey() { return mKey; }

    /**
     * Calculates the enciphered (i.e. permuted) value of the given integer
     * under the current key.
     *
     * @param plain the integer to encipher.
     *
     * @return the enciphered (permuted) value.
     */
    private static long LARGE_VAL=1l<<32;
    private long encipher(int plain) {
        // 1 Split into two halves.
        int rhs = plain & LOW_16_MASK;
        int lhs = plain >>> HALF_SHIFT;

        // 2 Do NUM_ROUNDS simple Feistel rounds.
        for (int i = 0; i < NUM_ROUNDS; ++i) {
            if (i > 0) {
                // Swap lhs <-> rhs
                final int temp = lhs;
                lhs = rhs;
                rhs = temp;
            } // end if
            // Apply Feistel round function F().
            rhs ^= F(lhs, i);
        } // end for

        // 3 Recombine the two halves and return.
        long v= (lhs << HALF_SHIFT) + (rhs & LOW_16_MASK);
        //把负数变成正数
        if(v<0){
        	v+=LARGE_VAL;
        }
        return v;
    } // end encipher()
    
    private long encipher(long plain) {
        // 1 Split into two halves.
        long rhs = plain & LOW_16_MASK;
        long lhs = plain >>> HALF_SHIFT;

        // 2 Do NUM_ROUNDS simple Feistel rounds.
        for (int i = 0; i < NUM_ROUNDS; ++i) {
            if (i > 0) {
                // Swap lhs <-> rhs
                final long temp = lhs;
                lhs = rhs;
                rhs = temp;
            } // end if
            // Apply Feistel round function F().
            rhs ^= F(lhs, i);
        } // end for

        // 3 Recombine the two halves and return.
        long v= (lhs << HALF_SHIFT) + (rhs & LOW_16_MASK);
        //把负数变成正数
        if(v<0){
        	v+=LARGE_VAL;
        }
        return v;
    } // end encipher(


    /**
     * Calculates the deciphered (i.e. inverse permuted) value of the given
     * integer under the current key.
     *
     * @param cypher the integer to decipher.
     *
     * @return the deciphered (inverse permuted) value.
     */
    private int decipher(long cypherlong) {
    	int cypher=0;
    	if(cypherlong> Integer.MAX_VALUE){
    		cypher=(int)(cypherlong-LARGE_VAL);
    	}else{
    		cypher=(int)cypherlong;
    	}
        // 1 Split into two halves.
        int rhs = cypher & LOW_16_MASK;
        int lhs = cypher >>> HALF_SHIFT;

        // 2 Do NUM_ROUNDS simple Feistel rounds.
        for (int i = 0; i < NUM_ROUNDS; ++i) {
            if (i > 0) {
                // Swap lhs <-> rhs
                final int temp = lhs;
                lhs = rhs;
                rhs = temp;
            } // end if
            // Apply Feistel round function F().
            rhs ^= F(lhs, NUM_ROUNDS - 1 - i);
        } // end for

        // 4 Recombine the two halves and return.
        return (lhs << HALF_SHIFT) + (rhs & LOW_16_MASK);
    } // end decipher()

    /////////////////////
    // Private Methods //
    /////////////////////

    // The F function for the Feistel rounds.
    private int F(int num, int round) {
        // XOR with round key.
        num ^= mRoundKeys[round];
        // Square, then XOR the high and low parts.
        num *= num;
        return (num >>> HALF_SHIFT) ^ (num & LOW_16_MASK);
    } // end F()
    
    
 // The F function for the Feistel rounds.
    private long F(long num, int round) {
        // XOR with round key.
        num ^= mRoundKeys[round];
        // Square, then XOR the high and low parts.
        num *= num;
        return (num >>> HALF_SHIFT) ^ (num & LOW_16_MASK);
    } // 
 
    public String encrypt(int id) throws Exception {
    	return ""+this.encipher(id);
    }   
    
    public String encrypt(long id) throws Exception {
    	return ""+this.encipher(id);
    }   

    public long encryptToLong(int id) throws Exception {
    	return this.encipher(id);
    }
    
    public String encryptWithoutException(int id) {
    	String str = null;
    	try {
    		str = this.encrypt(id);
    	} catch(Exception e) {
    		LogUtils.logError("error in encrypt. id:" + id);
    		e.printStackTrace();
    	}
    	return str;
    }
    
    public String encryptWithoutException(long id) {
    	String str = null;
    	try {
    		str = this.encrypt(id);
    	} catch(Exception e) {
            LogUtils.logError("error in encrypt. id:" + id);
    		e.printStackTrace();
    	}
    	return str;
    }
    
    public int decryptWithoutException(String str) {
    	int id = -1;
    	try {
   	 		id = this.decipher(Long.valueOf(str));
    	} catch(Exception e) {
            LogUtils.logError("error in decrypt. str:" + str);
    		e.printStackTrace();
    	}
    	return id;
    }
    
    

    public String encryptWithUrlEncoding(int id) throws Exception {
    	return this.encrypt(id);
    }
    
    public int decryptStr(String str) throws Exception {
    	return this.decipher(Long.valueOf(str));
    }
    
    public int decrypt(String str) throws Exception {
    	return this.decipher(Long.valueOf(str));
    }
    
    public String doubleEncrypt(int id) {
    	String first = encryptWithoutException(id);
    	return encryptWithoutException(Long.valueOf(first));
    }
    
    public int doubleDecrypt(String str) {
    	int first = decryptWithoutException(str);
    	
    	return decryptWithoutException(first + "");
    }
    public static void main(String[] args){
    	IDEncryptor enc=IDEncryptor.getInstance();

        try {
            System.out.println(enc.decrypt("EA187BC2C34B1DE694BE8487CAD63F03"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

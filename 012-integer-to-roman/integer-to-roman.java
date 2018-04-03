// Given an integer, convert it to a roman numeral.
//
//
// Input is guaranteed to be within the range from 1 to 3999.


class Solution {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if(num>=1000){
            int g = num/1000;
            for(int i = 0; i<g; i++){
                sb.append("M");
            }
            num%=1000;
        }
        
        if(num>=100){
            if(num/100 == 9){
                sb.append("CM");
            }
            if(num/100>=5 && num/100<9){
                sb.append("D");
                int s = num - 500;
                int g = s/100;
                for(int i = 0; i<g; i++){
                    sb.append("C");
                }
            }
            if(num/100<5){
                if(num/100==4){
                    sb.append("CD");
                }else{
                    int g = num/100;
                    for(int i = 0; i<g; i++){
                        sb.append("C");
                    }
                }
            }
            num%=100;
        }
        
        if(num>=10){
            if(num/10 == 9){
                sb.append("XC");
            }
            if(num/10>=5 && num/10<9){
                sb.append("L");
                    int s = num - 50;
                    int g = s/10;
                    for(int i = 0; i<g; i++){
                        sb.append("X");
                    } 
            }
            if(num/10<5){
                if(num/10==4){
                    sb.append("XL");
                }else{
                int g = num/10;
                for(int i = 0; i<g; i++){
                    sb.append("X");
                }
                }
            }
            num%=10;
        }
        if(num>=1){
            if(num == 9){
                sb.append("IX");
            }
            if(num>=5 && num<9){
                
                    sb.append("V");
                    int s = num - 5;
                    int g = s;
                    for(int i = 0; i<g; i++){
                        sb.append("I");
                    }
                
            }
            if(num<5){
                if(num == 4){
                    sb.append("IV");
                }else{
                int g = num;
                for(int i = 0; i<g; i++){
                    sb.append("I");
                }
                }
            }
        }
        
        return sb.toString();
    }
}

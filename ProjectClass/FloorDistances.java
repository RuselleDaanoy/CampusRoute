public class FloorDistances {
    
    private int [][] floor1 = {
        {0,8,0,0,0,0,0,0,0,0,0,0},
        {8,0,11,0,0,0,50,0,0,0,0,0},
        {0,11,0,3,4,0,0,0,0,0,0,0},
        {0,0,3,0,7,22,0,0,0,0,0,0},
        {0,0,4,7,0,0,0,0,0,0,0,0},
        {0,0,0,22,0,0,0,0,0,0,0,0},
        {0,50,0,0,0,0,0,10,0,0,0,0},
        {0,0,0,0,0,0,10,0,5,12,0,0},
        {0,0,0,0,0,0,0,5,0,13,9,0},
        {0,0,0,0,0,0,0,12,13,0,0,0},
        {0,0,0,0,0,0,0,0,9,0,0,19},
        {0,0,0,0,0,0,0,0,0,0,19,0}
        };
        
        
       private int [][] floor2 = {
        {0,8,7,4,0,0,0,0,0,0},
        {8,0,0,0,0,0,45,0,0,0},
        {7,0,0,0,0,0,0,0,0,50},
        {4,0,0,0,5,0,0,0,0,0},
        {0,0,0,5,0,70,0,40,0,0},
        {0,0,0,0,70,0,32,0,0,0},
        {0,45,0,0,0,32,0,0,0,0},
        {0,0,0,0,40,0,0,0,30,0},
        {0,0,0,0,0,0,0,30,0,35},
        {0,0,50,0,0,0,0,0,35,0}
        };
        
        private int [][] floor3 = {
        {0,5,40,0,0,0,0,48},
        {5,0,0,0,0,10,44,0},
        {50,0,0,13,0,0,0,0},
        {0,0,13,0,12,0,0,0},
        {0,0,0,12,0,36,0,0},
        {0,10,0,0,36,0,0,0},
        {0,44,0,0,0,0,0,23},
        {48,0,0,0,0,0,23,0}    
        };
        
        private int [][] floor4 = {
        {0,8,13,5,0,0,0,0,0,0,0},
        {8,0,0,0,0,0,45,0,0,0,0},
        {13,0,0,0,0,0,0,0,0,0,21},
        {5,0,0,0,7,0,0,0,0,0,0,0},
        {0,0,0,7,0,35,0,24,0,0,0},
        {0,0,0,0,35,0,22,0,0,0,0},
        {0,45,0,0,0,22,0,0,0,0,0},
        {0,0,0,0,24,0,0,0,20,0,0},
        {0,0,0,0,0,0,0,20,0,13,0},
        {0,0,0,0,0,0,0,0,13,0,12},
        {0,0,29,0,0,0,0,0,0,12,0},    
        };

        public int[][] getFloor1() {
            return floor1;
        }

        public int[][] getFloor2() {
            return floor2;
        }

        public int[][] getFloor3() {
            return floor3;
        }

        public int[][] getFloor4() {
            return floor4;
        }

        public String[][] direction1 = {
            {"0", "Straight", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"Straight", "0", "Right", "0", "0", "0", "Left", "0", "0", "0", "0", "0"},
            {"0", "Right", "0", "Straight", "Left", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "Straight", "0", "Right", "Left", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "LeRight", "Left", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "Straight", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "Left", "0", "0", "0", "0", "0", "Right", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "Straight", "0", "Right", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "Straight", "0", "Right", "Right", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "Left", "Right", "0", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "Left", "0", "0", "Straight"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Straight", "0"},
        };
    
        private String[][] direction2 = {
            {"0", "Left", "Right", "Straight", "0", "0", "0", "0", "0", "0"},
            {"Straight", "0", "0", "0", "0", "0", "Straight", "0", "0", "0"},
            {"Left", "0", "0", "0", "0", "0", "0", "0", "0", "Straight"},
            {"Straight", "0", "0", "0", "Left", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "Right", "0", "Straight", "0", "Straight", "0", "0"},
            {"0", "0", "0", "0", "Right", "0", "Left", "0", "0", "0"},
            {"0", "Right", "0", "0", "0", "Right", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "Straight", "0", "0", "0", "Straight", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "Right", "0", "Right"},
            {"0", "0", "Left", "0", "0", "0", "0", "0", "Left", "0"}
        };

        public String[][] direction3 = {
            {"0", "Straight", "Left", "0", "0", "0", "0", "Right"},
            {"Straight", "0", "0", "0", "0", "Left", "Right", "0"},
            {"Left", "0", "0", "Right", "0", "0", "0", "0"},
            {"0", "0", "Straight", "0", "Straight", "0", "0", "0"},
            {"0", "0", "0", "Left", "0", "Right", "0", "0"},
            {"0", "Right", "0", "0", "Straight", "0", "0", "0"},
            {"0", "Left", "0", "0", "0", "0", "0", "Right"},
            {"Right", "0", "0", "0", "0", "0", "Left", "0"},
        };
        
        private String[][] direction4 = {
            {"0", "Left", "Right", "Straight", "0", "0", "0", "0", "0", "0", "0"},
            {"Straight", "0", "0", "0", "0", "0", "Straight", "0", "0", "0", "0"},
            {"Straight", "0", "0", "0", "0", "0", "0", "0", "0", "0", "Straight"},
            {"Straight", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "Right", "0", "Straight", "0", "Straight", "0", "0", "0"},
            {"0", "0", "0", "0", "Right", "0", "Left", "0", "0", "0", "0"},
            {"0", "Left", "0", "0", "0", "Right", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "Straight", "0", "0", "0", "Straight", "0", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "Left", "0", "Right", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "0", "Straight", "0", "Straight"},
            {"0", "0", "Right", "0", "0", "0", "0", "0", "0", "Left", "0"}
        };

        public String[][] getDirection1() {
            return direction1;
        }

        public String[][] getDirection2() {
            return direction2;
        }

        public String[][] getDirection3() {
            return direction3;
        }

        public String[][] getDirection4() {
            return direction4;
        }
 
}
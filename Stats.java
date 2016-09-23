/*will be a class for the stats to create an object for the stats
*/

/*created on: 9/18/2016
*last edited: 9/18/2016
*/

//package
package DnD_RollCalculator;

class Stats{
   private int strength;      //holds the player's STR
   private int constitution;  //holds the player's CON
   private int dexterity;     //holds the player's DEX
   private int intelligence;  //holds the player's INT
   private int wisdom;        //holds the player's WIS
   private int charisma;      //holds the player's CHA
   
   public Stats(){
      this.strength = 10;
      this.constitution = 10;
      this.dexterity = 10;
      this.intelligence = 10;
      this.wisdom = 10;
      this.charisma = 10;
   }
   public Stats(int strength, int constitution, int dexterity,
               int intelligence, int wisdom, int charisma){
      this.strength = strength;
      this.constitution = constitution;
      this.dexterity = dexterity;
      this.intelligence = intelligence;
      this.wisdom = wisdom;
      this.charisma = charisma;
   }
   public Stats(int[] st){
      this.strength = st[0];
      this.constitution = st[1];
      this.dexterity = st[2];
      this.intelligence = st[3];
      this.wisdom = st[4];
      this.charisma = st[5];
   }
   
   public void setStrength(int strength){
      this.strength = strength;
   }
   public void setConstitution(int constitution){
      this.constitution = constitution;
   }
   public void setDexterity(int dexterity){
      this.dexterity = dexterity;
   }
   public void setIntelligence(int intelligence){
      this.intelligence = intelligence;
   }
   public void setWisdom(int wisdom){
      this.wisdom = wisdom;
   }
   public void setCharisma(int charisma){
      this.charisma = charisma;
   }
   
   public int getStrength(){
      return strength;
   }
   public int getConstitution(){
      return constitution;
   }
   public int getDexterity(){
      return dexterity;
   }
   public int getIntelligence(){
      return intelligence;
   }
   public int getWisdom(){
      return wisdom;
   }
   public int getCharisma(){
      return charisma;
   }
   
   public String toString(){
      String statsStr = "STR: " + strength + "\t\t" + " Mod: " + statModCalc(strength) +
                 "\nCON: " + constitution + "\t\t" +  " Mod: " + statModCalc(constitution) +
                 "\nDEX: " + dexterity + "\t\t" + " Mod: " + statModCalc(dexterity) +
                 "\nINT: " + intelligence + "\t\t" + " Mod: " + statModCalc(intelligence) +
                 "\nWIS: " + wisdom + "\t\t" + " Mod: " + statModCalc(wisdom) +
                 "\nCHA: " + charisma + "\t\t" + " Mod: " + statModCalc(charisma);
      return statsStr;
   }
   
   private int statModCalc(int stat){
      int statMod;
      statMod = (stat-10)/2;
      return statMod;
   }
}
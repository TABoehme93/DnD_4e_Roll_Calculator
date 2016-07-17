/*Thomas Boehme
*RollCalculator program
*CharacterHeroic class
*will do calculations on the character when needed
*/

/*Will eventually have the Paragon and Epic classes
*these will exend from each other

/*created on: 7/7/2016
*last edited: 7/17/2016
*/

//package
package DnD_RollCalculator;

class CharacterHeroic{
   private int charLevel;              //character generic info
   private String charClass;
   private String charRace;
   
   private int charSTR;                //character stats
   private int charCON;
   private int charDEX;
   private int charINT;
   private int charWIS;
   private int charCHA;
   
   private String[] weaponProf = new String[7];   //characer wepaon profs
   private String charWeapon;
   private String charWeaponType;
   private int charWeaponProf;
   private boolean charProfInWeapon;
   
   public CharacterHeroic(int ch_level, String ch_class, String ch_race, int ch_STR,            //initializer
                           int ch_CON, int ch_DEX, int ch_INT, int ch_WIS, int ch_CHA){
      
      this.charLevel = ch_level;          //sets values of needed variables
      this.charClass = ch_class;
      this.charRace = ch_race;
      this.charSTR = ch_STR;
      this.charCON = ch_CON;
      this.charDEX = ch_DEX;
      this.charINT = ch_INT;
      this.charWIS = ch_WIS;
      this.charCHA = ch_CHA;
      
      getWeaponProfs();                //gets weapon proficiency 
   }
   
   private void getWeaponProfs(){
      if (charClass == "Cleric"){            //for Cleric
         weaponProf[0] = "Simple Melee";
         weaponProf[1] = "Simple Ranged";
      }else if (charClass == "Fighter"){      //for Fighter
         weaponProf[0] = "Simple Melee";
         weaponProf[1] = "Military Melee";
         weaponProf[2] = "Simple Ranged";
         weaponProf[3] = "Military Melee";
      }else if (charClass == "Paladin"){      //for Paladin
         weaponProf[0] = "Simple Melee";
         weaponProf[1] = "Military Melee";
         weaponProf[2] = "Simple Ranged";
      }else if (charClass == "Ranger"){      //for Ranger
         weaponProf[0] = "Simple Melee";
         weaponProf[1] = "Military Melee";
         weaponProf[2] = "Simple Ranged";
         weaponProf[3] = "Military Melee";
      }else if (charClass == "Rogue"){      //for Rogue
         weaponProf[0] = "Dagger";
         weaponProf[1] = "Hand Crossbow";
         weaponProf[2] = "Shuriken";
         weaponProf[3] = "Sling";
         weaponProf[4] = "Short Sword";
      }else if (charClass == "Warlock"){      //for Warlock
         weaponProf[0] = "Simple Melee";
         weaponProf[1] = "Simple Ranged";
      }else if (charClass == "Warlord"){      //for Warlord
         weaponProf[0] = "Simple Melee";
         weaponProf[1] = "Military Melee";
         weaponProf[2] = "Simple Ranged";
      }else if (charClass == "Wizard"){      //for Wizard
         weaponProf[0] = "Dagger";
         weaponProf[1] = "Quarterstaff";
      }
      if (charRace == "Dwarf"){
         weaponProf[5] = "Throwing Hammer";
         weaponProf[6] = "Warhammer";
      }else if (charRace == "Eladrin"){
         weaponProf[5] = "Longsword";
      }else if (charRace == "Elf"){
         weaponProf[5] = "Longbow";
         weaponProf[6] = "Shortbow";
      }
   }
   //the setters for all the variables
   public void setCharLevel(int ch_level){         //character level
      this.charLevel = ch_level;
   }
   public void setCharClass(String ch_class){      //character class
      this.charClass = ch_class;
      getWeaponProfs();    //resets the weaponProf
   }
   public void setCharRace(String ch_race){        //character race
      this.charRace = ch_race;
      getWeaponProfs();    //resets the weaponProf
   }
   public void setCharSTR(int ch_STR){             //character strength
      this.charSTR = ch_STR;
   }
   public void setCharCON(int ch_CON){             //character constitution
      this.charCON = ch_CON;
   }
   public void setCharDEX(int ch_DEX){             //character dexterity 
      this.charDEX = ch_DEX;
   }
   public void setCharINT(int ch_INT){             //character intelligence
      this.charINT = ch_INT;
   }
   public void setCharWIS(int ch_WIS){             //character wisdom
      this.charWIS = ch_WIS;
   }
   public void setCharCHA(int ch_CHA){             //character charisma
      this.charCHA = ch_CHA;
   }
   public void setWeapon(String ch_weapon){           //character weapon
      this.charWeapon = ch_weapon;
   }
   public void setWeaponType(String ch_weaponType){   //character weapon type
      this.charWeaponType = ch_weaponType;
   }
   public void setWeaponProf(int ch_weaponProf){      //character weapon proficiency
      this.charWeaponProf = ch_weaponProf;
   }
   //the gets of all the general information
   public int getCharLevel(){                      //return level
      return charLevel;
   }
   public String getCharClass(){                      //return class
      return charClass;
   }
   public String getCharRace(){                      //return race
      return charRace;
   }
   public int getCharSTR(){                      //return strength
      return charSTR;
   }
   public int getCharCON(){                      //return constitution
      return charCON;
   }
   public int getCharDEX(){                      //return dexterity
      return charDEX;
   }
   public int getCharINT(){                      //return intelligence
      return charINT;
   }
   public int getCharWIS(){                      //return wisdom
      return charWIS;
   }
   public int getCharCHA(){                      //return charisma
      return charCHA;
   }
   public String getCharWeapon(){               //return weapon
      return charWeapon;
   }
   public String getCharWeaponType(){           //return weapon type
      return charWeaponType;
   }
   public int getCharWeaponProf(){           //return weaopn proficiency
      return charWeaponProf;
   }
   //checks if the character has the weapon proficiency to get proficiency bonus
   public boolean checkWeaponProf(String weapon, String weaponType){    //gets the weapon an its type
      this.charWeapon = weapon;
      this.charWeaponType = weaponType;
      for(int i = 0; i < 7; i++){
         if (weaponType == weaponProf[i]){      //first checks for weapon type proficiency
            this.charProfInWeapon = true;
            return true;
         }else if (weapon == weaponProf[i]){    //then for the specific weapon
            this.charProfInWeapon = true;
            return true;
         }
      }//end of for loop up to 7 but not 7
      this.charProfInWeapon = false;
      return false;                             //if character does not have proficency
   }
   //returns string information
   public String toString(){
      String message = "Class: " + charClass + "\nRace: " + charRace + "\nLevel: " +
         charLevel + "\n" + statsString() + "\nWeapon : " + charWeapon + "\nWeapon Attack: " +
         weaponAttackString();
      return message;
   }
   //returns stat roll modifiers for generic rolls and non-weapon attack rolls
   private String statsString(){
      String stats = "STR: " + ((charLevel/2) + abilityModCalc(charSTR)) +
                     "\nCON: " + ((charLevel/2) + abilityModCalc(charCON)) +
                     "\nDEX: " + ((charLevel/2) + abilityModCalc(charDEX)) +
                     "\nINT: " + ((charLevel/2) + abilityModCalc(charINT)) +
                     "\nWIS: " + ((charLevel/2) + abilityModCalc(charWIS)) +
                     "\nCHA: " + ((charLevel/2) + abilityModCalc(charCHA));
      return stats;
   }
   private int abilityModCalc(int stat){
      int abilityMod;
      abilityMod = (stat-10)/2;
      return abilityMod;
   }
   //returns string for weapon attack rolls
   private int weaponAttackString(){
      int roll;
      //for if the character has a melee weapon
      if ((charWeaponType == "Simple Melee" || charWeaponType == "Military Melee" || charWeaponType == "Superior Melee") &&
         charProfInWeapon){
         //with proficiency
         roll = (charLevel/2) + abilityModCalc(charSTR) + charWeaponProf;
         return roll;
      }else if (charWeaponType == "Simple Melee" || charWeaponType == "Military Melee" || charWeaponType == "Superior Melee"){
         //without proficiency
         roll = (charLevel/2) + abilityModCalc(charSTR);
         return roll;
      }else if ((charWeaponType == "Simple Ranged" || charWeaponType == "Military Ranged" || charWeaponType == "Superior Ranged") &&
         charProfInWeapon){         //for if the character has a ranged weapon
         //with proficiency
         roll = (charLevel/2) + abilityModCalc(charDEX) + charWeaponProf;
         return roll;
      }else if (charWeaponType == "Simple Ranged" || charWeaponType == "Military Ranged" || charWeaponType == "Superior Ranged"){
         //without proficiency
         roll = (charLevel/2) + abilityModCalc(charDEX);
         return roll;
      }else if (charWeapon == "Improvized Melee" || charWeapon == "Unarmed"){//for if the character is using an improvized weaponif it is melee
         roll = (charLevel/2) + abilityModCalc(charSTR);    //if it is melee
         return roll;
      }else{            //if it is ranged
         roll = (charLevel/2) + abilityModCalc(charDEX);
         return roll;
      }
   }
}
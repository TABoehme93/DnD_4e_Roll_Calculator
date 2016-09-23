/*Thomas Boehme
*RollCalculator program
*Heroic_4e class
*will do calculations on the character when needed
*/

/*Will eventually have the Paragon and Epic classes
*these will exend from each other

/*created on: 7/7/2016
*last edited: 9/23/2016    --added in the Stats object and created and implement abstaract class
*/

//package
package DnD_RollCalculator;

abstract class Character{              //so that I can use this as a base for all other editions of D&D later on
   private int charLevel;
   private String charClass;
   private String charRace;
   private Stats charStats;
}

class Heroic_4e extends Character{
   private int charLevel;              //character generic info
   private String charClass;
   private String charRace;
   
   private Stats charStats;
   
   private String[] weaponProf = new String[7];   //characer wepaon profs
   private String charWeapon;
   private String charWeaponType;
   private int charWeaponProf;
   private boolean charProfInWeapon;
   
   public Heroic_4e(int ch_level, String ch_class, String ch_race, Stats ch_stats){    //initializer
      
      this.charLevel = ch_level;          //sets values of needed variables
      this.charClass = ch_class;
      this.charRace = ch_race;
      this.charStats = ch_stats;
      
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
         charLevel + "\n" + charStats.toString() + "\nWeapon : " + charWeapon + "\nWeapon Attack: " +
         weaponAttackString();
      return message;
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
         roll = (charLevel/2) + abilityModCalc(charStats.getStrength()) + charWeaponProf;
         return roll;
      }else if (charWeaponType == "Simple Melee" || charWeaponType == "Military Melee" || charWeaponType == "Superior Melee"){
         //without proficiency
         roll = (charLevel/2) + abilityModCalc(charStats.getStrength());
         return roll;
      }else if ((charWeaponType == "Simple Ranged" || charWeaponType == "Military Ranged" || charWeaponType == "Superior Ranged") &&
         charProfInWeapon){         //for if the character has a ranged weapon
         //with proficiency
         roll = (charLevel/2) + abilityModCalc(charStats.getDexterity()) + charWeaponProf;
         return roll;
      }else if (charWeaponType == "Simple Ranged" || charWeaponType == "Military Ranged" || charWeaponType == "Superior Ranged"){
         //without proficiency
         roll = (charLevel/2) + abilityModCalc(charStats.getDexterity());
         return roll;
      }else if (charWeapon == "Improvized Melee" || charWeapon == "Unarmed"){//for if the character is using an improvized weaponif it is melee
         roll = (charLevel/2) + abilityModCalc(charStats.getStrength());    //if it is melee
         return roll;
      }else{            //if it is ranged
         roll = (charLevel/2) + abilityModCalc(charStats.getDexterity());
         return roll;
      }
   }
}
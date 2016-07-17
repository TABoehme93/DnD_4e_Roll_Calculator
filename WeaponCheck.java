/*Thomas Boehme
*RollCalculator program
*WeaponCheck class
*will calculated what the weapon choice is, by type then give prof
*/

/*created on: 7/7/2016
*last edited: 7/17/2016
*/

//package
package DnD_RollCalculator;

class WeaponCheck{
   private String charWeapon;          //sets private values for weapon information
   private String charWeaponType;
   
   //values for the weapon type groups
   private static final String[] SIMPLEMELEE = {"Club", "Dagger", "Javelin",              //simple melee group
      "Mace", "Sickle", "Spear", "Great Club", "Morningstar", "Quarterstaff", "Scythe"};
      
   private static final String[] MILITARYMELEE = {"Battleaxe", "Flail", "Handaxe", "Longsword",    //military melee group
      "Scimitar", "Short Sword", "Throwing Hammer", "Warhammer", "War Pick", "Falchion", "Glaive",
      "Greataxe", "Halberd", "Heavy Flail", "Longspear", "Maul", "Greatsword"};
      
   private static final String[] SIMPLERANGED = {"Hand Crossbow", "Sling", "Crossbow"};      //simple ranged group
   
   private static final String[] MILITARYRANGED = {"Longbow", "Shortbow"};                //military ranged group
   
   private static final String[] SUPERIORMELEE = {"Bastard Sword", "Katar", "Rapier",     //superior melee group
      "Spiked Chain"};
   
   private static final String[] SUPERIORRANGED = {"Shuriken"};                           //superior ranged group
   
   private static final String[] IMPROVIZED = {"Improvized Melee", "Unarmed",
      "Improvized Ranged"};
   //array for weapons with proficiency of +2
   private static final String[] PROF2 = {"Club", "Javelin", "Mace", 
      "Sickle", "Spear", "Great Club", "Morningstar", "Quarterstaff", "Scythe",
      "Battleaxe", "Flail", "Handaxe", "Scimitar", "Throwing Hammer", "Warhammer",
      "War Pick", "Glaive", "Greataxe", "Halberd", "Heavy Flail", "Longspear", "Maul",
      "Hand Crossbow", "Sling", "Crossbow", "Longbow", "Shortbow"};
   //array for weapons with proficiency of +3
   private static final String[] PROF3 = {"Dagger", "Longsword", "Short Sword",
      "Falchion", "Greatsword", "Bastard Sword", "Katar", "Rapier", "Spiked Chain",
      "Shuriken"};
      
   public WeaponCheck(String weapon){
      this.charWeapon = weapon;
      this.charWeaponType = typeCheck(weapon);  //gets the weapon type
   }
   
   private String typeCheck(String weapon){           //find weapon in:
      if (arrayTest(SIMPLEMELEE, weapon)){            //simple melee
         return "Simple Melee";
      }else if (arrayTest(MILITARYMELEE, weapon)){    //military melee
         return "Military Melee";
      }else if (arrayTest(SIMPLERANGED, weapon)){     //simple ranged
         return "Simple Ranged";
      }else if (arrayTest(MILITARYRANGED, weapon)){   //military ranged
         return "Military Ranged";
      }else if (arrayTest(SUPERIORMELEE, weapon)){    //superior melee
         return "Superior Melee";
      }else if (arrayTest(SUPERIORRANGED, weapon)){   //superior ranged
         return "Superior Ranged";
      }else if (arrayTest(IMPROVIZED, weapon)){       //improvized
         return "Improvized";
      }else{                                          //if not in any send something to always fail
         return "no group";
      }
   }
   private boolean arrayTest(String[] weaponGroup, String weapon){  //to see if weapon is in an array
      for (int i=0; i < weaponGroup.length; i++){
         if(weapon == weaponGroup[i]){
            return true;
         }
      }
      return false;
   }
   //setter of the class
   public void setWeapon(String weapon){
      this.charWeapon = weapon;
      this.charWeaponType = typeCheck(weapon);  //gets the weapon type
   }
   //getters of the class
   public String getWeapon(){
      return charWeapon;
   }
   public String getWeaponType(){
      return charWeaponType;
   }
   //gets the weapon proficiency
   public int getWeaponProficiency(){
      if (arrayTest(PROF2, charWeapon)){
         return 2;
      }else if (arrayTest(PROF3, charWeapon)){
         return 3;
      }else{
         return 0;
      }
   }
}
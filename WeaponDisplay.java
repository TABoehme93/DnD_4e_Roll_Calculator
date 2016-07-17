/*Thomas Boehme
*RollCalculator program
*WeaponDisplay class
*will display the weapons that will be displayed in the calculator
*/

/*created on: 7/6/2016
*last edited: 7/9/2016
*/

//package
package DnD_RollCalculator;

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class WeaponDisplay{
   private JPanel weaponPanel = new JPanel();
   
   private JRadioButton club = new JRadioButton("Club");             //Simple Melee weapons
   private JRadioButton dagger = new JRadioButton("Dagger");
   private JRadioButton javelin = new JRadioButton("Javelin");
   private JRadioButton mace = new JRadioButton("Mace");
   private JRadioButton sickle = new JRadioButton("Sickle");
   private JRadioButton spear = new JRadioButton("Spear");
   private JRadioButton greatClub = new JRadioButton("Great Club");
   private JRadioButton morningstar = new JRadioButton("Morningstar");
   private JRadioButton quarterstaff = new JRadioButton("Quarterstaff");
   private JRadioButton scythe = new JRadioButton("Scythe");
   
   private JRadioButton battleaxe = new JRadioButton("Battleaxe");   //Military Melee weapons
   private JRadioButton flail = new JRadioButton("Flail");
   private JRadioButton handaxe = new JRadioButton("Handaxe");
   private JRadioButton longsword = new JRadioButton("Longsword");
   private JRadioButton scimitar = new JRadioButton("Scimitar");
   private JRadioButton shortSword = new JRadioButton("Short Sword");
   private JRadioButton throwingHammer = new JRadioButton("Throwing Hammer");
   private JRadioButton warhammer = new JRadioButton("Warhammer");
   private JRadioButton warPick = new JRadioButton("War Pick");
   private JRadioButton falchion = new JRadioButton("Falchion");
   private JRadioButton glaive = new JRadioButton("Glaive");
   private JRadioButton greataxe = new JRadioButton("Greataxe");
   private JRadioButton greatsword = new JRadioButton("Greatsword");
   private JRadioButton halberd = new JRadioButton("Halberd");
   private JRadioButton heavyFlail = new JRadioButton("Heavy Flail");
   private JRadioButton longspear = new JRadioButton("Longspear");
   private JRadioButton maul = new JRadioButton("Maul");
   
   private JRadioButton handCrossbow = new JRadioButton("Hand Crossbow");  //Simple Ranged weapons
   private JRadioButton sling = new JRadioButton("Sling");
   private JRadioButton crossbow = new JRadioButton("Crossbow");
   
   private JRadioButton longbow = new JRadioButton("Longbow");             //Military Ranged weapons
   private JRadioButton shortbow = new JRadioButton("Shortbow");
   
   private JRadioButton bastardSword = new JRadioButton("Bastard Sword");  //Superior Melee weapons
   private JRadioButton katar = new JRadioButton("Katar");
   private JRadioButton rapier = new JRadioButton("Rapier");
   private JRadioButton spikedChain = new JRadioButton("Spiked Chain");
   
   private JRadioButton shuriken = new JRadioButton("Shuriken");           //Superior Ranged weapons
   
   private JRadioButton improvizedMelee = new JRadioButton("Improvized Melee"); //Improvized attacks
   private JRadioButton improvizedRanged = new JRadioButton("Improvized Ranged");
   private JRadioButton unarmed = new JRadioButton("Unarmed");
   
   protected ButtonGroup weaponChoice = new ButtonGroup();     //what the player chooses
   
   public WeaponDisplay(){
      weaponPanel.setLayout(new GridLayout(15, 3, 5, 5));          //sets layout
      
      weaponChoice.add(club);             //so only one weapon is chosen, simple melee
      weaponChoice.add(dagger);
      weaponChoice.add(javelin);
      weaponChoice.add(mace);
      weaponChoice.add(sickle);
      weaponChoice.add(spear);
      weaponChoice.add(greatClub);
      weaponChoice.add(morningstar);
      weaponChoice.add(quarterstaff);
      weaponChoice.add(scythe);
      
      weaponChoice.add(battleaxe);        //so only one weapon is chosen, military melee
      weaponChoice.add(flail);
      weaponChoice.add(handaxe);
      weaponChoice.add(longsword);
      weaponChoice.add(scimitar);
      weaponChoice.add(shortSword);
      weaponChoice.add(throwingHammer);
      weaponChoice.add(warhammer);
      weaponChoice.add(warPick);
      weaponChoice.add(falchion);
      weaponChoice.add(glaive);
      weaponChoice.add(greataxe);
      weaponChoice.add(greatsword);
      weaponChoice.add(halberd);
      weaponChoice.add(heavyFlail);
      weaponChoice.add(longspear);
      weaponChoice.add(maul);
      
      weaponChoice.add(handCrossbow);     //so only one weapon is chosen, simple ranged
      weaponChoice.add(sling);
      weaponChoice.add(crossbow);
      
      weaponChoice.add(longbow);          //so only one weapon is chosen, miliary ranged
      weaponChoice.add(shortbow);
      
      weaponChoice.add(bastardSword);     //so only one weapon is chosen, superior melee
      weaponChoice.add(katar);
      weaponChoice.add(rapier);
      weaponChoice.add(spikedChain);
      
      weaponChoice.add(shuriken);     //so only one weapon is chosen, superior ranged
      
      weaponChoice.add(improvizedMelee);            //so only one weapon is chosen, improvized
      weaponChoice.add(improvizedRanged);
      weaponChoice.add(unarmed);
      
      
      weaponPanel.add(club);              //adds the weapons to the panel, simple melee
      weaponPanel.add(dagger);
      weaponPanel.add(javelin);
      weaponPanel.add(mace);
      weaponPanel.add(sickle);
      weaponPanel.add(spear);
      weaponPanel.add(greatClub);
      weaponPanel.add(morningstar);
      weaponPanel.add(quarterstaff);
      weaponPanel.add(scythe);
      
      weaponPanel.add(battleaxe);         //adds the weapons to the panel, military melee
      weaponPanel.add(flail);
      weaponPanel.add(handaxe);
      weaponPanel.add(longsword);
      weaponPanel.add(scimitar);
      weaponPanel.add(shortSword);
      weaponPanel.add(throwingHammer);
      weaponPanel.add(warhammer);
      weaponPanel.add(warPick);
      weaponPanel.add(falchion);
      weaponPanel.add(glaive);
      weaponPanel.add(greataxe);
      weaponPanel.add(greatsword);
      weaponPanel.add(halberd);
      weaponPanel.add(heavyFlail);
      weaponPanel.add(longspear);
      weaponPanel.add(maul);
      
      weaponPanel.add(handCrossbow);         //adds the weapons to the panel, simple ranged
      weaponPanel.add(sling);
      weaponPanel.add(crossbow);
      
      weaponPanel.add(longbow);         //adds the weapons to the panel, military ranged
      weaponPanel.add(shortbow);
      
      weaponPanel.add(bastardSword);        //adds the weapons to the panel, superior melee
      weaponPanel.add(katar);
      weaponPanel.add(rapier);
      weaponPanel.add(spikedChain);
      
      weaponPanel.add(shuriken);        //adds the weapons to the panel, superior ranged
      
      weaponPanel.add(improvizedMelee);             //adds the weapons to the panel, imporvized
      weaponPanel.add(improvizedRanged);
      weaponPanel.add(unarmed);

      
      
      club.setActionCommand("Club");      //returns weapon name, simple melee
      dagger.setActionCommand("Dagger");
      javelin.setActionCommand("Javelin");
      mace.setActionCommand("Mace");
      sickle.setActionCommand("Sickle");
      spear.setActionCommand("Spear");
      greatClub.setActionCommand("Great Club");
      morningstar.setActionCommand("Morningstar");
      quarterstaff.setActionCommand("Quarterstaff");
      scythe.setActionCommand("Scythe");
      
      battleaxe.setActionCommand("Battleaxe");     //returns weapon name, military melee
      flail.setActionCommand("Flail");
      handaxe.setActionCommand("Handaxe");
      longsword.setActionCommand("Longsword");
      scimitar.setActionCommand("Scimitar");
      shortSword.setActionCommand("Short Sword");
      throwingHammer.setActionCommand("Throwing Hammer");
      warhammer.setActionCommand("Warhammer");
      warPick.setActionCommand("War Pick");
      falchion.setActionCommand("Falchion");
      glaive.setActionCommand("Glaive");
      greataxe.setActionCommand("Greataxe");
      halberd.setActionCommand("Halberd");
      heavyFlail.setActionCommand("Heavy Flail");
      longspear.setActionCommand("Longspear");
      greataxe.setActionCommand("Greataxe");
      greatsword.setActionCommand("Greatsword");
      maul.setActionCommand("Maul");
      
      handCrossbow.setActionCommand("Hand Crossbow");        //returns weapon name, simple ranged
      sling.setActionCommand("Sling");
      crossbow.setActionCommand("Crossbow");
      
      longbow.setActionCommand("Longbow");                   //returns weapon name, military ranged
      shortbow.setActionCommand("Shortbow");
      
      bastardSword.setActionCommand("Bastard Sword");        //returns weapon name, superior melee
      katar.setActionCommand("Katar");
      rapier.setActionCommand("Rapier");
      spikedChain.setActionCommand("Spiked Chain");
      
      shuriken.setActionCommand("Shuriken");        //returns weapon name, superior ranged
      
      improvizedMelee.setActionCommand("Improvized Melee");              //returns weapon name, improvized
      improvizedRanged.setActionCommand("Improvized Ranged");
      unarmed.setActionCommand("Unarmed");
      
      
      club.setSelected(true);             //so club is first selected weapon
   }
   
   public JComponent getWeaponComponent(){
      return weaponPanel;
   }
}
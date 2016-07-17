/*Thomas Boehme
*started:         6/27/2016
*last edidted:    7/17/2016  --edits were cleaning up comments
*finished:        7/14/2016  --first part
*/

/*Allows one to calculate damage and other effects
*that a character's attack roll will be for 4e D&D.
*In GUI form.
*/

/*currently starting with getting infromation form the Player's
*Handbook I to do calculations.
*/

/*currently finished the first part what I planned out
*from here I need to learn how to grab and use infromation form
*a database.
*/

//package
package DnD_RollCalculator;
/*this gives access to the WeaponDisplay class
*more to come
*/

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//the main class used in the program
public class RollCalculator{
   private JPanel mainPanel = new JPanel();                 //adds in needed panel
   private CharacterClassDisplay characterClassDisplay = new CharacterClassDisplay();
   private static final String CLASSES = "classes";
   private CharacterRaceDisplay characterRaceDisplay = new CharacterRaceDisplay();
   private static final String RACES = "races";
   private CharacterLevelDisplay characterLevelDisplay = new CharacterLevelDisplay();
   private static final String LEVEL = "level";
   private StatsDisplay statsDisplay = new StatsDisplay();
   private static final String STATS = "stats";
   private WeaponDisplay weaponDisplay = new WeaponDisplay();
   private static final String WEAPON = "weapon";
   private CalculateDisplay calculateDisplay = new CalculateDisplay();
   private static final String CALC = "calculate";
   
   private String charClass;     //gets the player's class
   private String charRace;      //gets the player's race
   private int charLevel;        //gets the player's level
   
   private int strength;      //gets the player's STR
   private int constitution;  //gets the player's CON
   private int dexterity;     //gets the player's DEX
   private int intelligence;  //gets the player's INT
   private int wisdom;        //gets the player's WIS
   private int charisma;      //gets the player's CHA
   private String statsStr;   //puts all stats in a string
   
   private String charWeapon;    //gets the player's weapon name for now, weapon prof as int later
   
   private CharacterHeroic character;
   private WeaponCheck weapon;
   private int weaponProf;
   
   public RollCalculator(){                                 //handles actions
      mainPanel.add(characterLevelDisplay.getCharacterLevelComponent(), LEVEL);     //gets the level panel
      mainPanel.setLayout(new GridLayout(0, 4));
      mainPanel.add(characterClassDisplay.getCharacterClassComponent(), CLASSES);   //gets the class panel
      mainPanel.add(characterRaceDisplay.getCharacterRaceComponent(), RACES);       //gets the races panel
      mainPanel.add(statsDisplay.getStatsComponent(), STATS);                       //gets the stats panel
      mainPanel.add(weaponDisplay.getWeaponComponent(), WEAPON);                    //gets the weapons panel
      mainPanel.add(calculateDisplay.getCalculateComponent(), CALC);                //gets the calculate panel
      
      //when the calculate button is clicked
      calculateDisplay.addCalculateListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e){
            while(true){         //makes it so that if there is an error the program will break out of the listener
               charClass = characterClassDisplay.characterClassButtons.getSelection().getActionCommand();   //gets class
               charRace = characterRaceDisplay.characterRaceButtons.getSelection().getActionCommand();      //gets race
               charWeapon = weaponDisplay.weaponChoice.getSelection().getActionCommand();                  //gets weapon name
               
               if (characterLevelDisplay.level_TF.getText().equals("")){         //gets level
                  infoBox("No level entered", "Submit Level button");
                  break; 
               }else{
                  charLevel = Integer.parseInt(characterLevelDisplay.level_TF.getText());
                  if (!(charLevel > 0 && charLevel < 31)){
                     infoBox(charLevel + " is not a valid level", "Submit Level button");
                     break;
                  }
               }
               //checks for the stats
               if (statsDisplay.strength_TF.getText().equals("")){            //for STR
                  infoBox("No STR entered", "Submit Stats button");
                  break;
               }else if (statsDisplay.constitution_TF.getText().equals("")){  //for CON
                  infoBox("No CON entered", "Submit Stats button");
                  break;
               }else if (statsDisplay.dexterity_TF.getText().equals("")){     //for DEX
                  infoBox("No DEX entered", "Submit Stats button");
                  break;
               }else if (statsDisplay.intelligence_TF.getText().equals("")){  //for INT
                  infoBox("No INT entered", "Submit Stats button");
                  break;
               }else if (statsDisplay.wisdom_TF.getText().equals("")){        //for WIS
                  infoBox("No WIS entered", "Submit Stats button");
                  break;
               }else if (statsDisplay.charisma_TF.getText().equals("")){      //for CHA
                  infoBox("No CHA entered", "Submit Stats button");
                  break;
               }else{               //creates a stats string
                  strength = Integer.parseInt(statsDisplay.strength_TF.getText());
                  constitution = Integer.parseInt(statsDisplay.constitution_TF.getText());
                  dexterity = Integer.parseInt(statsDisplay.dexterity_TF.getText());
                  intelligence = Integer.parseInt(statsDisplay.intelligence_TF.getText());
                  wisdom = Integer.parseInt(statsDisplay.wisdom_TF.getText());
                  charisma = Integer.parseInt(statsDisplay.charisma_TF.getText());
                  //makes a string for the stats
                  statsStr = "STR: " + strength + "\t\t" + " Mod: " + abilityModCalc(strength) +
                     "\nCON: " + constitution + "\t\t" +  " Mod: " + abilityModCalc(constitution) +
                     "\nDEX: " + dexterity + "\t\t" + " Mod: " + abilityModCalc(dexterity) +
                     "\nINT: " + intelligence + "\t\t" + " Mod: " + abilityModCalc(intelligence) +
                     "\nWIS: " + wisdom + "\t\t" + " Mod: " + abilityModCalc(wisdom) +
                     "\nCHA: " + charisma + "\t\t" + " Mod: " + abilityModCalc(charisma);
               }
               character = new CharacterHeroic(charLevel, charClass, charRace, strength,    //sends info down to character to run calcs
                  constitution, dexterity, intelligence, wisdom, charisma);
               weapon = new WeaponCheck(charWeapon);                                         //allow for weapon checks
               character.checkWeaponProf(charWeapon, weapon.getWeaponType());
               character.setWeaponProf(weapon.getWeaponProficiency());
               calcInfoBox(character, "Testing");
               break;
            }//while(true) loop end, should break at some point before end
         }
      });//calculateDisplay.addCalculateListener(new ActionListener() end
   }//public RollCalculator() end
   
   //show an error for an action
   public static void infoBox(String message, String title){
      JOptionPane.showMessageDialog(null, message, "Infobox: " + title, JOptionPane.INFORMATION_MESSAGE);
   }
   //shows the character info when asked
   public static void calcInfoBox(CharacterHeroic character, String title){
      JOptionPane.showMessageDialog(null, character.toString(), "CharCalcInfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
   }
   //returns the panel currently being used
   private JComponent getMainComponent(){
      return mainPanel;
   }
   //returns ability score modifiers, to be moved to CharacterHeroic class
   public static int abilityModCalc(int abilityScore){
      int abilityMod;
      abilityMod = (abilityScore-10)/2;
      return abilityMod;
   }
   
   private static void createStandardUI(){
      JFrame frame = new JFrame("Roll Calculator");
      frame.setSize(200, 500);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().add(new RollCalculator().getMainComponent());
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
   
   public static void main(String[] args){      //starts the program
      java.awt.EventQueue.invokeLater(new Runnable(){
         public void run(){
            createStandardUI();
         }
      });
   }
}

class StatsDisplay{
   private JPanel statsPanel = new JPanel();
   
   private JLabel strength_L = new JLabel("STR");
   protected JTextField strength_TF = new JTextField("10");       //get strength
   private JLabel constitution_L = new JLabel("CON");
   protected JTextField constitution_TF = new JTextField("10");   //get constitution
   
   private JLabel dexterity_L = new JLabel("DEX");
   protected JTextField dexterity_TF = new JTextField("10");      //get dexterity
   private JLabel intelligence_L = new JLabel("INT");
   protected JTextField intelligence_TF = new JTextField("10");   //get intelligence
   
   private JLabel wisdom_L = new JLabel("WIS");
   protected JTextField wisdom_TF = new JTextField("10");         //get wisdom
   private JLabel charisma_L = new JLabel("CHA");
   protected JTextField charisma_TF = new JTextField("10");       //get charisma
   
   public StatsDisplay(){                                   //creates the JPanel
      statsPanel.setLayout(new GridLayout(7, 2, 5, 5));
      
      statsPanel.add(strength_L);
      statsPanel.add(strength_TF);
      statsPanel.add(constitution_L);
      statsPanel.add(constitution_TF);
      
      statsPanel.add(dexterity_L);
      statsPanel.add(dexterity_TF);
      statsPanel.add(intelligence_L);
      statsPanel.add(intelligence_TF);
      
      statsPanel.add(wisdom_L);
      statsPanel.add(wisdom_TF);
      statsPanel.add(charisma_L);
      statsPanel.add(charisma_TF);
   }
   public JComponent getStatsComponent(){    //to get the panel
      return statsPanel;
   }
}

class CharacterClassDisplay{         //gives a series of radio buttons to select a class
   private JPanel characterClassPanel = new JPanel();
   
   private JRadioButton cleric = new JRadioButton("Cleric");
   private JRadioButton fighter = new JRadioButton("Fighter");
   private JRadioButton paladin = new JRadioButton("Paladin");
   private JRadioButton ranger = new JRadioButton("Ranger");
   private JRadioButton rogue = new JRadioButton("Rogue");
   private JRadioButton warlock = new JRadioButton("Warlock");
   private JRadioButton warlord = new JRadioButton("Warlord");
   private JRadioButton wizard = new JRadioButton("Wizard");
   //creates the group for the radio buttons so only one is selected
   protected ButtonGroup characterClassButtons = new ButtonGroup();
   
   public CharacterClassDisplay(){
      characterClassPanel.setLayout(new GridLayout(9, 1, 5, 5));  //sets the layout
      
      characterClassButtons.add(cleric);     //adds the radio buttons to the group
      characterClassButtons.add(fighter);
      characterClassButtons.add(paladin);
      characterClassButtons.add(ranger);
      characterClassButtons.add(rogue);
      characterClassButtons.add(warlock);
      characterClassButtons.add(warlord);
      characterClassButtons.add(wizard);
      
      characterClassPanel.add(cleric);       //adds the radio buttons to the panel
      characterClassPanel.add(fighter);
      characterClassPanel.add(paladin);
      characterClassPanel.add(ranger);
      characterClassPanel.add(rogue);
      characterClassPanel.add(warlock);
      characterClassPanel.add(warlord);
      characterClassPanel.add(wizard);
      
      cleric.setActionCommand("Cleric");     //allows the buttons to return
      paladin.setActionCommand("Paladin");   //information for if it is selected
      fighter.setActionCommand("Fighter");
      ranger.setActionCommand("Ranger");
      rogue.setActionCommand("Rogue");
      warlock.setActionCommand("Warlock");
      warlord.setActionCommand("Warlord");
      wizard.setActionCommand("Wizard");
      
      cleric.setSelected(true);              //so that cleric is selected at start
   }
   
   public JComponent getCharacterClassComponent(){
      return characterClassPanel;
   }
}

class CharacterRaceDisplay{               //allows the user to select their race
   private JPanel characterRacePanel = new JPanel();
   
   private JRadioButton dragonborn = new JRadioButton("Dragonborn");
   private JRadioButton dwarf = new JRadioButton("Dwarf");
   private JRadioButton eladrin = new JRadioButton("Eladrin");
   private JRadioButton elf = new JRadioButton("Elf");
   private JRadioButton half_elf = new JRadioButton("Half-Elf");
   private JRadioButton halfling = new JRadioButton("Halfling");
   private JRadioButton human = new JRadioButton("Human");
   private JRadioButton tiefling = new JRadioButton("Tiefling");
   //creates the group for the radio buttons so only one is selected
   protected ButtonGroup characterRaceButtons = new ButtonGroup();
   
   public CharacterRaceDisplay(){
      characterRacePanel.setLayout(new GridLayout(9, 1, 5, 5));  //sets the layout
      
      characterRaceButtons.add(dragonborn);     //adds the radio buttons to the group
      characterRaceButtons.add(dwarf);
      characterRaceButtons.add(eladrin);
      characterRaceButtons.add(elf);
      characterRaceButtons.add(half_elf);
      characterRaceButtons.add(halfling);
      characterRaceButtons.add(human);
      characterRaceButtons.add(tiefling);
      
      characterRacePanel.add(dragonborn);       //adds the radio buttons to the panel
      characterRacePanel.add(dwarf);
      characterRacePanel.add(eladrin);
      characterRacePanel.add(elf);
      characterRacePanel.add(half_elf);
      characterRacePanel.add(halfling);
      characterRacePanel.add(human);
      characterRacePanel.add(tiefling);
      
      dragonborn.setActionCommand("Dragonborn");     //allows the buttons to return
      dwarf.setActionCommand("Dwarf");               //information for if it is selected
      eladrin.setActionCommand("Eladrin");
      elf.setActionCommand("Elf");
      half_elf.setActionCommand("Half-Elf");
      halfling.setActionCommand("Halfling");
      human.setActionCommand("Human");
      tiefling.setActionCommand("Tiefling");
      
      dragonborn.setSelected(true);              //so that cleric is selected at start
   }
   
   public JComponent getCharacterRaceComponent(){
      return characterRacePanel;
   }
}

class CharacterLevelDisplay{                 //allows the user to input their level
   private JPanel levelPanel = new JPanel();
   
   private JLabel levelLabel = new JLabel("Enter Level:");
   protected JTextField level_TF = new JTextField("1");
   
   public CharacterLevelDisplay(){
      levelPanel.setLayout(new GridLayout(1, 2, 5, 5));
      
      levelPanel.add(levelLabel);         //gives prompt for user to enter level
      levelPanel.add(level_TF);            //lets the user input level
   }
   
   public JComponent getCharacterLevelComponent(){
      return levelPanel;
   }
}

class CalculateDisplay{
   private JPanel calculatePanel = new JPanel();
   private JButton calculate = new JButton("Calculate");
   
   public CalculateDisplay(){
      calculatePanel.add(calculate);
   }
   public JComponent getCalculateComponent(){
      return calculatePanel;
   }
   public void addCalculateListener(ActionListener listener){
      calculate.addActionListener(listener);
   }
}
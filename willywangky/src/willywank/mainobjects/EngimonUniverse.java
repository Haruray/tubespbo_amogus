package willywank.mainobjects;

import java.util.*;

public class EngimonUniverse {

public static int mapsize = 10;
public static Map map;
//ELEMENTS
public static Element Fire = new Element("Fire");
public static Element Water = new Element("Water");
public static Element Electric = new Element("Electric");
public static Element Ground = new Element("Ground");
public static Element Ice = new Element("Ice");
//Skills
public static Skill WaterfallSkill = new Skill("Waterfall", 80, 5, new ArrayList<Element>() {{add(Water);}});
public static Skill WaterSplash = new Skill("WaterSplash", 100, 4, new ArrayList<Element>() {{add(Water);}});
public static Skill Sabotage = new Skill("Sabotage", 20, 10, new ArrayList<Element>() {{add(Electric);}});
public static Skill Mandom = new Skill("Mandom", 120, 3, new ArrayList<Element>() {{add(Electric);}});
public static Skill Crimson = new Skill("Crimson", 200, 2, new ArrayList<Element>() {{add(Fire);}});
public static Skill FireFang = new Skill("FireFang", 100, 5, new ArrayList<Element>() {{add(Fire);}});
public static Skill Bufu = new Skill("Bufu", 120, 3, new ArrayList<Element>() {{add(Ice);}});
public static Skill WhiteAlbum = new Skill("White Album", 100, 5, new ArrayList<Element>() {{add(Ice);}});
public static Skill Rock = new Skill("Rock", 100, 4, new ArrayList<Element>() {{add(Ground);}});
public static Skill SandAttack = new Skill("SandAttack", 150, 2, new ArrayList<Element>() {{add(Ground);}});
public static Skill HallowedSlash = new Skill("HallowedSlash", 120, 5, new ArrayList<Element>() {{add(Fire);}});
public static Skill Rumbling = new Skill("Rumbling",150, 5, new ArrayList<Element>() {{add(Ground);}});
public static Skill Freeze = new Skill("Freeze!", 20 , 4, new ArrayList<Element>() {{add(Ice);}});
public static Skill BurstStream = new Skill("BURST STREAM OF DESTRUCTION!", 150, 5, new ArrayList<Element>() {{add(Fire); add(Electric);}});
public static Skill InfernoFire = new Skill("Inferno Fire Blast", 170, 4, new ArrayList<Element>() {{add(Fire); add(Ground);}});
public static Skill Pftz = new Skill("pftzzz", 100, 6, new ArrayList<Element>() {{add(Fire); add(Ice);}});
public static Skill DualBreath = new Skill("Dual Breath", 110, 6, new ArrayList<Element>() {{add(Fire); add(Ice);}});
public static Skill StinkyBreath = new Skill("Stinky Breath", 110, 6, new ArrayList<Element>() {{add(Water); add(Ground);}});
public static Skill Zap = new Skill("Zap!", 130, 6, new ArrayList<Element>() {{add(Water); add(Electric);}});
public static Skill Castle = new Skill("Make a castle", 120, 7, new ArrayList<Element>() {{add(Water); add(Ice);}});
public static Skill NoVoltage = new Skill("No Voltage", 100, 8, new ArrayList<Element>() {{add(Electric); add(Ground);}});
public static Skill Incest = new Skill("Incest", 100, 6, new ArrayList<Element>() {{add(Ground); add(Ice);}});
public static Skill ZapRequiem = new Skill("Zap Requiem", 130, 7, new ArrayList<Element>() {{add(Electric); add(Ice);}});
public static List<Skill> skillList = new ArrayList<Skill>(Arrays.asList(WaterfallSkill, WaterSplash, Sabotage, Mandom, Crimson, FireFang, Bufu, WhiteAlbum, Rock, SandAttack, HallowedSlash, Rumbling, Freeze, BurstStream, InfernoFire, Pftz, DualBreath, StinkyBreath, Zap, Castle, Castle, NoVoltage, Incest, ZapRequiem));
//Species
public static Species Watortle = new Species("Watortle", "Waaaa!", WaterfallSkill);
public static Species Koikingu = new Species("Koikingu", "I'm a fish, meow", WaterSplash);
public static Species Impostor = new Species("Impostor", "Sus!", Sabotage);
public static Species Raishuu = new Species("Raishuu", "Rokubyou", Mandom);
public static Species Saider = new Species("Saider", "Apple Sauce", Crimson);
public static Species Rizadon = new Species("Rizadon", "420 Moyase!", FireFang);
public static Species Bufumon = new Species("Bufumon", "Hee Ho!", Bufu);
public static Species IceCube = new Species("IceCube", "I'm just an ice cube", WhiteAlbum);
public static Species Golem = new Species("Golem", "I'm the gaming golem", Rock);
public static Species Diguda = new Species("Diguda", "Toransu!", SandAttack);
public static Species Wyrm = new Species("Wyrm", "No cost too great", HallowedSlash);
public static Species Ymir = new Species("Ymir", "To you, 2000 years from now", Rumbling);
public static Species SuperSuit = new Species("SuperSuit","WHERE IS MY SUPER SUIT??", Freeze);

public static Species BlueEyes = new Species("Blue Eyes", "Kaiba is my b*tch, b*tch.", BurstStream);
public static Species RedEyes = new Species("Red Eyes", "I'm a plot armor.", InfernoFire);
public static Species GreenEyes = new Species("Green Eyes", "I'm not canon kekw", Pftz);
public static Species Jakiro = new Species("Jakiro", "from dota or warcraft, idk", DualBreath);
public static Species Schnozer = new Species("Schnozer", "nose.", StinkyBreath);
public static Species CyberDragon = new Species("Cyber Dragon", "Another yu-gi-oh reference..yay", Zap);
public static Species DisneyPrincess = new Species("Disney Princess", "Let it go... Let it go! (that gay disney song)", Castle);
public static Species Grounded = new Species("Grounded", "Get it? ahahahahAHHAHAHA", NoVoltage);
public static Species ACDC = new Species("ACDC", "You see, in JoJo part 2, ACDC controls heat. So, we made ACDC controls electric now", ZapRequiem);
public static Species Trump = new Species("Trump", "Make Americunt great again", Incest);
public static List<Species> multElementSpecies = new ArrayList<Species>(Arrays.asList(BlueEyes, RedEyes, GreenEyes, Jakiro, Schnozer, CyberDragon, DisneyPrincess, Grounded, ACDC, Trump));

//Engimon
public static Engimon JackFrost = new Engimon("JackFrost", null, null, Bufumon, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ice);}}, 1, 10000);
public static Engimon Raool = new Engimon("Raool", null, null, Saider, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Fire);}}, 1, 10000);
public static Engimon Dababy = new Engimon("Dababy", null, null, Golem, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ground);}}, 1, 10000);
public static Engimon Waluigi = new Engimon("Waluigi", null, null, Watortle, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Water);}}, 1, 10000);
public static Engimon Ringo = new Engimon("Ringo", null, null, Raishuu, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Electric);}}, 1, 10000);
public static Engimon Raoq = new Engimon("Raoq", null, null, Wyrm, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Fire);}}, 1, 10000);
public static Engimon Hilarious = new Engimon("Hilarious", null, null, Impostor, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Electric);}}, 1, 10000);
public static Engimon Valentine = new Engimon("Valentine", null, null, Diguda, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ground);}}, 1, 10000);
public static Engimon Dio = new Engimon("Dio", null, null, IceCube, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ground);}}, 1, 10000);
public static Engimon Mio = new Engimon("Mio", null, null, Koikingu, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Water);}}, 1, 10000);
public static Engimon Gaybon = new Engimon("Gaybon", null, null, Watortle, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Water);}}, 1, 10000);
public static Engimon Eren = new Engimon("Eren", null, null, Ymir, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ground);}}, 1 , 10000);
public static Engimon Frozone = new Engimon("Frozone", null, null, SuperSuit, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ice);}}, 1, 10000);
public static List<Engimon> engimons = new ArrayList<Engimon>(Arrays.asList(JackFrost, Raool, Dababy, Waluigi, Ringo, Raoq, Hilarious, Valentine, Dio, Mio, Gaybon, Eren, Frozone));

//enemies
public static Enemy JackFrostE = new Enemy("JackFrost", null, null, Bufumon, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ice);}}, 1, 10000, 0, 0);
public static Enemy RaoolE = new Enemy("Raool", null, null, Saider, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Fire);}}, 1, 10000, 0, 0);
public static Enemy DababyE = new Enemy("Dababy", null, null, Golem, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ground);}}, 1, 10000, 0, 0);
public static Enemy WaluigiE = new Enemy("Waluigi", null, null, Watortle, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Water);}}, 1, 10000, 0, 0);
public static Enemy RingoE = new Enemy("Ringo", null, null, Raishuu, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Electric);}}, 1, 10000, 0, 0);
public static Enemy RaoqE = new Enemy("Raoq", null, null, Wyrm, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Fire);}}, 1, 10000, 0, 0);
public static Enemy HilariousE = new Enemy("Hilarious", null, null, Impostor, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Electric);}}, 1, 10000, 0, 0);
public static Enemy ValentineE = new Enemy("Valentine", null, null, Diguda, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ground);}}, 1, 10000, 0, 0);
public static Enemy DioE = new Enemy("Dio", null, null, IceCube, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ground);}}, 1, 10000, 0, 0);
public static Enemy MioE = new Enemy("Mio", null, null, Koikingu, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Water);}}, 1, 10000, 0, 0);
public static Enemy GaybonE = new Enemy("Gaybon", null, null, Watortle, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Water);}}, 1, 10000, 0, 0);
public static Enemy ErenE = new Enemy("Eren", null, null, Ymir, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ground);}}, 1 , 10000, 0, 0);
public static Enemy FrozoneE = new Enemy("Frozone", null, null, SuperSuit, new ArrayList<Skill>(), new ArrayList<Element>() {{add(Ice);}}, 1, 10000, 0, 0);
public static List<Enemy> enemies = new ArrayList<Enemy>(Arrays.asList(JackFrostE, RaoolE, DababyE, WaluigiE, RingoE, RaoqE, HilariousE, ValentineE, DioE, MioE, GaybonE, ErenE, FrozoneE));

}

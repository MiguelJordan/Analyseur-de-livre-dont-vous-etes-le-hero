package analyseur.questions;
import analyseur.backbone.Page;
import analyseur.extraction.BookLabel;
import analyseur.extraction.JsonBuilder;
import analyseur.model.Graph;
import analyseur.model.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;





public class MainAnalyse {
  
  
       public static void main(String[] args) {
        JsonBuilder j = new JsonBuilder("res/hero.json", 
        new BookLabel("sections", "choices", "section","text"));
        List<Page> pages;
        pages= j.getPages();
        Graph graph = new Graph(pages);
       // List<Node> nodes = graph.getNodes();
    
      RandomWalk r = new RandomWalk(graph);
      System.out.println("La probabilite de victoire : "+ r.simulator("1", "350", 1000));

      //for(Page p: pages ){
       // System.out.println(p);
     //}
           

     System.out.println("#########################################################");
     
     Graph graph1 = new Graph(pages);
     Map<String, Node> nodesMap = new HashMap<>();
     nodesMap = graph1.getNodeMap();
    // System.out.println(nodes);
     PathFindingBFS bfs = new PathFindingBFS(nodesMap.get("1"), nodesMap.get("350"), nodesMap);
     ArrayList<String> path = bfs.pathFindingBFS();
     System.out.println("#########################################################");
     System.out.println("Le plus court chemin :");
     System.out.println(path);
     System.out.println("#########################################################");
     AllPath allpath = new AllPath(nodesMap.get("1"), nodesMap.get("350"));
     List<List<String>> allpossible =  allpath.findAllPaths();
     System.out.println("le/s chemin/s qui nous mène à la victoire :");
     for (List<String> all : allpossible) {
     	System.out.println("Chemin : " + all);
     	}
     System.out.println("#########################################################");
     LongestPath longest = new LongestPath(nodesMap.get("1"), nodesMap.get("350"));
     Set<String> longroad = longest.path();
     System.out.println("le chemin le plus long :");
     System.out.println(longroad);
     /**Si on veux trier la liste
      * List<String> sortedPath = new ArrayList<>(path);
      * Collections.sort(sortedPath);
      * System.out.println(sortedPath);
     */
     System.out.println("#########################################################");
     Fight fight = new Fight();
     int fightNumbers = fight.totalFight(nodesMap);
     System.out.println("Le nombre total de combats est: "+fightNumbers);
     System.out.println("Le plus grand nombre  de combats pour une page est: "+fight.mostFightNumber(nodesMap));
     System.out.println("La page qui a le plus de combats est: "+fight.mostFightNode(nodesMap));
     System.out.println("#########################################################");
     Dead d = new Dead();
     System.out.println("Le nombre de noeud de defaite est: "+d.nbrDeads(nodesMap));
     System.out.println("Ces differents noeuds sont : "+d.nodeDeads(nodesMap));
     System.out.println("#########################################################");
     /*for(Map.Entry<String,Node> n : nodesMap.entrySet()){
      System.out.println(n.getValue().getEdges().size());
     }*/
     List<String> defaites = new ArrayList<>();
     defaites = d.nodeDeads(nodesMap);
     ArrayList<String> deadShortPath = new ArrayList<>();
     ArrayList<String> deadShortPathTemp = new ArrayList<>();
     PathFindingBFS bfs2;
     bfs2 = new PathFindingBFS(nodesMap.get("1"), nodesMap.get("350"), nodesMap);
     deadShortPath = bfs2.pathFindingBFS();
     for(String s : defaites){
        bfs2 = new PathFindingBFS(nodesMap.get("1"), nodesMap.get(s), nodesMap);
        deadShortPathTemp = bfs2.pathFindingBFS();
        if(deadShortPath.size() > deadShortPathTemp.size()){
          deadShortPath = deadShortPathTemp;
          //System.out.println(deadShortPath+"\n longueur:"+deadShortPath.size());
        }
     }
     System.out.println("Le plus court chemin vers la defaite est :"+deadShortPath);
    }

}

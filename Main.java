/**
 * Main
 */
// package Ball;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;
import java.util.NoSuchElementException;

class TakeInput {
    String inputString(){
        Scanner sc = new Scanner(System.in);
        try {
            String input = sc.nextLine();
            return input;
        } catch (NoSuchElementException e) {
            System.out.println("No input found. Please enter a value:");
            String input = sc.nextLine();
            return input;
        }

        // System.out.println("");
        // Scanner sc = new Scanner(System.in);
        // String s = sc.nextLine();
        // sc.close();
        // return s;
    }

    int inputInt(){
        Scanner sc = new Scanner(System.in);
        try {
            int input = sc.nextInt();
            return input;
        } catch (NoSuchElementException e) {
            System.out.println("No input found. Please enter a value:");
            int input = sc.nextInt();
            return input;
        }
        // Scanner sc = new Scanner(System.in);
        // int s = sc.nextInt();
        // sc.close();
        // return s;
    }
}


class Ball {
    Player batsman;
    Player bowller;
    int result;

    Ball(Player b1,Player b2,int r){
        this.batsman = b1;
        this.bowller = b2;
        this.result = r;
    }

    boolean isWicket(){
        return result==7;
    }

    int getRun(){
        if(result==7) return 0;
        return result;
    }
}

class Player{
    String name;
    int run;
    int wicket;

    ArrayList<Ball> Balled;
    ArrayList<Ball> Batted;

    Player(String n){
        this.name = n;
    }

    void AddBowlledBall(Ball ball){
        if(ball==null){
            this.wicket++;
        }
        Balled.add(ball);
    }

    void AddBattedBall(Ball ball){
        run += ball.getRun();
        Batted.add(ball);
    }

}

class Team{
    String name;
    int run;
    int wicket;
    int number_of_player;

    Player firstPlayer;
    Player secondPlayer;
    Player bowler;

    ArrayList<Player> team_arr;
    ArrayList<Player> batting_order;
    ArrayList<Player> bowler_order;

    boolean isPlayerMatch(ArrayList<Player> arr,Player p){
        for(int i=0;i<arr.size();i++){
            Player x = arr.get(i);
            if(x==p){
                return true;
            }
        }
        return false;
    }

    boolean isMatchOver(){
        return batting_order.size()<=1;
    }

    void reset(){
        firstPlayer=null;
        secondPlayer=null;
        bowler=null;
    }

    Team(String name,int number_of_player){
        this.name = name;
        this.wicket = 0;
        reset();
        this.number_of_player = number_of_player;

        TakeInput t = new TakeInput();

        System.out.println("Creating Class of player ");

        for(int i=0;i<number_of_player;i++){
            System.out.print("enter name of player "+(i+1)+" : ");
            String newName = t.inputString();
            Player p = new Player(newName);
            team_arr.add(p);
        }

        System.out.println("Added Sucess ");
        
    }

    void setBattingOrder(){
        System.out.println("Please Set Team order \n\n ");

        TakeInput t = new TakeInput();

        for(int i=0;i<number_of_player;i++){
            System.out.println("Who will go in order "+(i+1));
        
            for(int j=0;j<team_arr.size();j++){
                Player p = team_arr.get(j);
                if(!isPlayerMatch(batting_order, p)){
                    System.out.println(j+" . for "+p.name);
                }
            }
            int x;
            System.out.print("Please Enter Number : ");
            x = t.inputInt();

            batting_order.add(team_arr.get(x));
        }
    }

    void setBowlerOrder(){
        TakeInput t = new TakeInput();
        System.out.print("First Enter number of bowler : ");
        int b;
        b = t.inputInt();

        for(int i=0;i<b;i++){
            System.out.println("who will go in order "+i);

            for(int j=0;j<team_arr.size();j++){
                Player p = team_arr.get(j);
                if(!isPlayerMatch(bowler_order, p)){
                    System.out.println(j+". for"+p.name);
                }
            }
            int x;
            System.out.print("\n Please Enter number : ");
            x = t.inputInt();

            bowler_order.add(team_arr.get(x));
        }

        System.out.println("Setted bowler");
    }

    void loadBatsman(){
        firstPlayer = batting_order.get(0);
        secondPlayer = batting_order.get(1);

        batting_order.remove(0);
        batting_order.remove(0);
    }

    void loadBowler(){
        bowler = bowler_order.get(0);
    }

    void swapBatsman(){
        Player temp = firstPlayer;
        firstPlayer = secondPlayer;
        secondPlayer = temp;
    }

    void outBatsman(){
        firstPlayer = batting_order.get(0);
        batting_order.remove(0);
        wicket++;
    }

    void changeBowler(){
        if(bowler==null){
            bowler = bowler_order.get(0);
            return ;
        }
        int index = 0;

        for(int i=0;i<bowler_order.size();i++){
            if(bowler==bowler_order.get(i)){
                index = i;
                break;
            }
        }

        if(index+1>=bowler_order.size()){
            index = 0;
        }else{
            index++;
        }

        bowler = bowler_order.get(index);
    }

    void PrintList(ArrayList<Player> list){
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

}

class RandomNumberGenerator {

    public int randGenerate(int lower, int upper) {
        Random rand = new Random();
        return rand.nextInt((upper - lower) + 1) + lower;
    }

}


class Match{
    Team team1;
    Team team2;

    int balls;

    int Toss(){
        RandomNumberGenerator r = new RandomNumberGenerator();
        return r.randGenerate(0, 1);
    }

    int ThrowBall(Player p1,Player p2){
        RandomNumberGenerator r = new RandomNumberGenerator();
        int num =  r.randGenerate(0, 1);

        Ball b = new Ball(p1, p2, num);
        p1.AddBattedBall(b);
        p2.AddBowlledBall(b);

        return num;
    }

    void PlayInning(Team t1,Team t2){
        t1.setBattingOrder();
        t2.setBattingOrder();

        t1.loadBatsman();
        t2.loadBowler();

        t1.PrintList(t1.batting_order);
        t2.PrintList(t2.bowler_order);

        int ballCnt = 1;

        for(ballCnt=1;ballCnt<=balls;ballCnt++){
            System.out.println("Balling");

            if(ballCnt%6==0){
                t2.changeBowler();
                System.out.println("Bowler changed ");
            }

            int result = ThrowBall(t1.firstPlayer,t2.bowler);

            if(result==7){
                System.out.println("Out ");
                t1.outBatsman();
                if(t1.batting_order.size()==0){
                    System.out.println("over \n\n\n\n");
                    break;
                }
            }else if(result%2!=0){
                System.out.println("Bat changed ");
                t1.swapBatsman();
            }

            if(result!=7){
                t1.run += result;
            }

            System.out.println(t1.batting_order.size());
            System.out.println(t1.firstPlayer.name+" "+result+" "+t2.bowler.name);


        }

    }

    Match(){
        balls = 120;

        TakeInput t = new TakeInput();

        System.out.print("Enter Team name ");
        String s1,s2;
        s1 = t.inputString();
        s2 = t.inputString();

        int p1 = t.inputInt();
        int p2 = t.inputInt();

        team1 = new Team(s1, p1);
        team2 = new Team(s2,p2);

        if(Toss()==0){
            Team temp = team1;
            team1 = team2;
            team2 = temp;
        }

        System.out.println("First inning ");

        PlayInning(team1, team2);
        PlayInning(team2, team1);

        System.out.println(team1.run);
        System.out.println(team2.run);

    }

}


public class Main {


    public static void main(String[] args) {
        // Ball b = new Ball();

        // b.Test();
        Match m = new Match();

        System.out.println("Hello, World!"); 
    }
}
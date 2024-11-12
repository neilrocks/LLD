/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
interface Observable{
    public void add(Observer obj);
    public void remove(Observer obj);
    public void notifyObserver();
    public void setData(int temp);
    public String getData();
}
class CricketScoreObservable implements Observable{
    List<Observer> list = new ArrayList();
    int score_updated = 0;
    public void add(Observer obj){
        list.add(obj);
    }
    public void remove(Observer obj){
        list.remove(obj);
    }
    public void notifyObserver(){
        for(Observer o:list){
            o.update();
        }
    }
    public void setData(int score){
        if(score_updated!=score){
            score_updated = score;
            notifyObserver();
        }
        
    }
    public String getData(){
        return "Score updated "+score_updated;
    }
}
class WeatherStationObservable implements Observable{
    List<Observer> list = new ArrayList();
    int temp_updated = 0;
    public void add(Observer obj){
        list.add(obj);
    }
    public void remove(Observer obj){
        list.remove(obj);
    }
    public void notifyObserver(){
        for(Observer o:list){
            o.update();
        }
    }
    public void setData(int temp){
        if(temp_updated!=temp){
            temp_updated = temp;
            notifyObserver();
        }
        
    }
    public String getData(){
        return "Temp updated "+temp_updated;
    }
}
interface Observer{
    public void update();
}
class TVDisplayObserver implements Observer{
    Observable obj;
    public TVDisplayObserver(Observable obj){
        this.obj = obj;
    }
    public void update(){
        System.out.println("TVDisplay updated");
        System.out.println(obj.getData());
    }
}
class MobDisplayObserver implements Observer{
    Observable obj;
    public MobDisplayObserver(Observable obj){
        this.obj = obj;
    }
    public void update(){
        System.out.println("MobDisplay updated");
        System.out.println(obj.getData());
    }
}
class Main
{
	public static void main(String[] args) {
		Observable obj1 = new WeatherStationObservable();
		Observable obj2 = new CricketScoreObservable();
		Observer tv_observer = new TVDisplayObserver(obj1);
		Observer mob_observer = new MobDisplayObserver(obj1);
		Observer mob_observer_crick = new MobDisplayObserver(obj2);
		obj1.add(tv_observer);
		obj1.add(mob_observer);
		obj1.setData(200);
		obj2.add(mob_observer_crick);
		obj2.setData(50);
	}
}
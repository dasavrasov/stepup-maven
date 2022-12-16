package ru.stepup.travel;

import java.util.ArrayList;
import java.util.List;

public class Town {
    String name;

    List<Route> routes= new ArrayList<Route>();

    public Town(String name) {
        this.name = name;
    }

    public Town(String name, List<Route> routes) {
        this.name = name;
        this.routes = routes;
    }

    public void addRoute(Route route){
        this.routes.add(route);
    }

    public void addRoute(Town town, int cost){
        this.routes.add(new Route(town, cost));
    }

    public void delRoute(Town town){
        for (Route route : this.routes) {
            if (route.dest.name==town.name)
                this.routes.remove(route);
        }
    }

    public Town travel(int depth){
        // берем первый город в routes
        String strRoute="";
        int i=0;
        Town src, dst;
        if (this.routes.isEmpty())
            return null;
        src=this;
        do {
            dst=src.routes.get(0).dest;
            strRoute+=" "+src.name+"->"+dst.name;
            src=dst;
            i++;
        } while (i<depth);
        System.out.println(strRoute);
        return dst;
    }

    @Override
    public String toString() {
        String str=this.name + " ";
        if (this.routes.isEmpty())
            return this.name;
        for (Route route : this.routes) {
            str+=" " + route;
        }
        return str;
    }
}

package hello09;

import hello08.MOVIE;

public class Movie介绍 {
    public static void main(String[] args) {
        MOVIEintro movie=new MOVIEintro();
        movie.name="我的2024";
        movie.director="微冷的雨";
        String []actors=new String[5];
        actors[0]="a";
        actors[1]="b";
        actors[2]="c";
        actors[3]="d";
        actors[4]="e";
        movie.initActors(actors);
        movie.show();
        System.out.println("=======================");
        MOVIEintro movie1=new MOVIEintro();
        movie.name="我的2025";
        movie.director="微热的雪";
        String []actors1=new String[5];
        actors1[0]="f";
        actors1[1]="g";
        actors1[2]="h";
        actors1[3]="i";
        actors1[4]="j";
        movie.initActors(actors1);
        movie.show();
    }
}

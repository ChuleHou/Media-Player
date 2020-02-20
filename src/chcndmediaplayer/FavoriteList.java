/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chcndmediaplayer;

/**
 *
 * @author houchule
 */
public class FavoriteList implements MyFavorite {
    @Override
    public void music(FavoriteList obj) {
       if(obj!=null){
         System.out.println("Because Of You"+"\n"
                 +"Five Hundred Miles"+"\n"
                 +"My Soul"+"\n"
                 +"SpongeBob"+"\n"
                 +"What's Up");    
        }
        else{    
           System.out.println("no list");
        }
    }
  
}


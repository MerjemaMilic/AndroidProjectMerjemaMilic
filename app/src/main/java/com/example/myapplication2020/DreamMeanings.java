package com.example.myapplication2020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DreamMeanings extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter adapter;
    ListActivity listActivity;
    FloatingActionButton buttonAdd;
    List<Dream> dreamList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dream_meanings);

        recyclerView = findViewById(R.id.dreamsList);

        dreamList = new ArrayList<>();

        adapter = new CustomAdapter(listActivity, dreamList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Dream dream = new Dream("Clown", "When you dream about clowns, it may indicate that you have a need for more light, humor and fun in your life. You may want to let your hair down and have more fun and be more fun to be around. It could also be that the clown is pointing to the fact that you exaggerate certain things in your life. Who and what this is should be revealed by the details of the clown dream. Such dreams also are often indicators of you or someone close to you putting on a happy face to help get through difficult times. Something else associated with clown" +
                " dreams is childhood fun. Such dreams may indicate that you are yearning for a simpler time, when it was all about you and you had no worries and cares.");
        Dream dream1 = new Dream("Unicorn", "The unicorn is a symbol of hope, insight, and high ideals. It also represents gentleness, power, and purity. In a dream, it suggests magical feelings or a wish for more magic and enchantment in your life. " +
                "It may also indicate that you or someone you know is a person of purity and innocence with high personal standards.");
        Dream dream2 = new Dream("Superhero", "The superhero symbolizes the super parts of you yourself. Maybe you are going through a time where qualities " +
                "you didn’t know you had are rising to the surface – for the better. Perhaps you are finding new wells of strength, talent, and creativity that you hadn’t used or " +
                "recognized in the past. Most superheroes have an alter ego, an identity that they use to cover up their super powers. Are you doing this? Most superhero alter egos are timid, quite, " +
                "“normal” people who purposely don’t stand out in a crowd or ever do anything worth mentioning. Is this how you view yourself? Your superhero dream may be your subconscious telling you to " +
                "stop hiding your light," +
                " for whatever reason you have done so in the past. It might just be time to let loose and see what you can do.");
        Dream dream3 = new Dream("Soldier", "Presence of the soldier represents your " +
                "own attitudes in life, particularly when it comes to your opinions and feelings. How do you share these things – your opinions and feelings – with others? Could be a little too insistent " +
                "at times? Are your attitudes and beliefs perhaps a little too staunchly held? Soldiers sometimes have strong beliefs and attitudes, and for good reason – in battle they must hold together " +
                "without doubt or dissention within the ranks. But in civilian life, this staunch attitude might bring you trouble with communication and relationships. Perhaps you tend to impose your beliefs " +
                "on other people, and your dreams are trying to help you think about this.");
        Dream dream4 = new Dream("Cat", "Cats symbolize the dreamer’s feelings as well. For example, a cat, especially a kitten, can represent vulnerability or a need for help. The dream cat may be telling you that independence is fine, but you should consider asking for help. It may also represent your feelings of emotional or sexual vulnerability." +
                "Cats also represent independence, agility, luck, and stealth. Some cultures believe that a car in a dream always means bad luck, unless you chase it away before you wake up. " +
                "Black cats have historically been linked with bad luck, but if you have a cat as a pet in your waking life, these negative cultural associations are not likely to apply to you. " +
                "Some interpretations suggest that seeing a black cat in a dream always means impending danger, " +
                "while a white cat represents your strong affection for a particular person.");
        Dream dream5 = new Dream("Butterfly", "The butterfly is symbolic of an intense transformation for the better and as such, it is associated with the soul and resurrection. It is sometimes thought to be an omen of death in the family. When associated with death, the dream butterfly appears to prepare the dreamer for the loss of loved one.\n" +
                "\n" +
                "The colors of the dream butterfly are important indicators of its meaning, as is its size – the bigger the butterfly, the greater impression you will make in a social situation.  " +
                "The dream butterfly suggests that you move more lightly in some endeavor and expect things to change as opportunities arise." +
                " The butterfly indicates that change is inevitable, but it does not have to be traumatic.");
        Dream dream6 = new Dream("Eagle", "To see an eagle in your dream symbolizes nobility, pride, fierceness, freedom, superiority, courage, " +
                " and powerful intellectual ability. It also represents self-renewal and your connection with your spirituality. " +
                "You will struggle fiercely and courageously to realize your highest ambitions and greatest desires. Alternatively, if you live in the United States, then the national bird could represent your patriotism and devotion to country."
                + "To see a chained or trapped eagle in your dream represents a desperate situation where you are feeling restricted and confined. You are unable to express yourself " +
                "and be who you really want to be. Consider also what the eagle is chained down to for additional " +
                "clues as to what might be holding you back. ");
        Dream dream7 = new Dream("Echo", "To hear or make an echo in your dream symbolizes your need to repeat yourself in order to be heard and for others to" +
                " believe you. Pay attention to the power and impact of your own words. You are waiting and hoping for a reaction from those around you. It is also symbolic of " +
                "the soul. Alternatively, to hear your own voice echo indicates that someone is mocking you." +
                " Or it could mean that your past actions will come back to haunt you. You need to confront those old memories and past issues.");
        Dream dream8 = new Dream("Balloon", "To see balloons in your dream indicate declining hopes and disappointments in your search for love. A situation in your life will take a turn downward. Balloons also represent arrogance and an inflated opinion of yourself. \n" +
                "To dream that you or someone is blowing up a balloon represents your aspirations, goals and ambitions. You are experiencing renewed hope." +
                "To see black balloons in your dream symbolizes depression, especially if the balloons are descending." +
                "To see an ascending balloon in your dream signifies frustrating conditions in your life in which you are seeking to rise above." +
                " You are expressing a desire to escape. On a positive note, balloons symbolize celebration and festivities. You need to acknowledge your inner child.");
        Dream dream9 = new Dream("Death", "To dream about the death of a loved one suggests that you are lacking a certain aspect or quality that the " +
                "loved one embodies. Ask yourself what makes this person special or what you like about them. It is that very quality that you are lacking in your own " +
                "relationship or circumstances. Alternatively, the dream indicates that whatever that person represents has no part in your own life anymore. In particular, to dream" +
                " about the death of your living parents indicates that you are undergoing a significant change in your waking life. Your relationship with your " +
                "parents has evolved into a new realm. If you dream about the death of a child, then it implies that you need to let go of your immaturity and start being more serious. As your child reaches certain milestones and grows into an adult," +
                " dreaming of their death may be symbolic of their own self-discovery, transition and transformation into a new stage of life.");
        Dream dream10 = new Dream("Deer", "o see a deer in your dream symbolizes grace, compassion, gentleness, meekness and natural beauty. " +
                "The deer has feminine qualities and may point to the feminine aspect within yourself. It also represents independence, alertness, and virility. Consider" +
                " the symbol to be a pun for someone who is \"dear\" to you. Alternatively, the dream represents vulnerability and naiveté. As a result, others may take " +
                "advantage of you and your gullibility." +
                "If the deer is black, then it means that you are not acknowledging or are rejecting the feminine qualities in you. You may not be in tune with your feminine " +
                "side. ");
        Dream dream11 = new Dream("Virus", "To dream that a computer has a virus or has crashed suggests that something in your life that is out of control." +
                " It may parallel something in your life that has come to a crashing end. If you dream that your computer has a sentient computer virus that would create random" +
                " or strange artwork, then it depicts your subconscious desires. The artwork may also be a reflection of a situation in your life that you are ignoring. " +
                "In particular, if the artwork is of a little boy smearing X's with his poop on a calendar, then it indicates past regrets or remorse." +
                "To dream that you have a viral infection or contracted a virus suggests that you are experiencing an unpleasant change or an emotional breakdown in your" +
                " waking life.");

        dreamList.add(dream8);
        dreamList.add(dream5);
        dreamList.add(dream7);
        dreamList.add(dream9);
        dreamList.add(dream10);
        dreamList.add(dream6);
        dreamList.add(dream4);
        dreamList.add(dream);
        dreamList.add(dream3);
        dreamList.add(dream2);
        dreamList.add(dream1);
        dreamList.add(dream11);


    }


}

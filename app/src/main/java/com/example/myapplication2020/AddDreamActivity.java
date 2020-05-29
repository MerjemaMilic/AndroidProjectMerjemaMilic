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

public class AddDreamActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    FloatingActionButton buttonAdd;
    List<Dream> dreamList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dream);
        recyclerView = findViewById(R.id.dreamsList);
         dreamList = new ArrayList<>();
        String[] titles = getResources().getStringArray(R.array.dreams_titles);
        String[] contents = getResources().getStringArray(R.array.dreamscontent);

        adapter = new Adapter(this, dreamList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        Dream dream = new Dream("Clown","When you dream about clowns, it may indicate that you have a need for more light, humor and fun in your life. You may want to let your hair down and have more fun and be more fun to be around. It could also be that the clown is pointing to the fact that you exaggerate certain things in your life. Who and what this is should be revealed by the details of the clown dream. Such dreams also are often indicators of you or someone close to you putting on a happy face to help get through difficult times. Something else associated with clown" +
                " dreams is childhood fun. Such dreams may indicate that you are yearning for a simpler time, when it was all about you and you had no worries and cares.");
        Dream dream1 = new Dream("Unicorn","The unicorn is a symbol of hope, insight, and high ideals. It also represents gentleness, power, and purity. In a dream, it suggests magical feelings or a wish for more magic and enchantment in your life. " +
                "It may also indicate that you or someone you know is a person of purity and innocence with high personal standards.");
        Dream dream2 = new Dream("Superhero","The superhero symbolizes the super parts of you yourself. Maybe you are going through a time where qualities " +
                "you didn’t know you had are rising to the surface – for the better. Perhaps you are finding new wells of strength, talent, and creativity that you hadn’t used or " +
                "recognized in the past. Most superheroes have an alter ego, an identity that they use to cover up their super powers. Are you doing this? Most superhero alter egos are timid, quite, " +
                "“normal” people who purposely don’t stand out in a crowd or ever do anything worth mentioning. Is this how you view yourself? Your superhero dream may be your subconscious telling you to " +
                "stop hiding your light," +
                " for whatever reason you have done so in the past. It might just be time to let loose and see what you can do.");
        Dream dream3 = new Dream("Soldier","Presence of the soldier represents your " +
                "own attitudes in life, particularly when it comes to your opinions and feelings. How do you share these things – your opinions and feelings – with others? Could be a little too insistent " +
                "at times? Are your attitudes and beliefs perhaps a little too staunchly held? Soldiers sometimes have strong beliefs and attitudes, and for good reason – in battle they must hold together " +
                "without doubt or dissention within the ranks. But in civilian life, this staunch attitude might bring you trouble with communication and relationships. Perhaps you tend to impose your beliefs " +
                "on other people, and your dreams are trying to help you think about this.");
        Dream dream4 = new Dream("Cat","Cats symbolize the dreamer’s feelings as well. For example, a cat, especially a kitten, can represent vulnerability or a need for help. The dream cat may be telling you that independence is fine, but you should consider asking for help. It may also represent your feelings of emotional or sexual vulnerability." +
                "Cats also represent independence, agility, luck, and stealth. Some cultures believe that a car in a dream always means bad luck, unless you chase it away before you wake up. " +
                "Black cats have historically been linked with bad luck, but if you have a cat as a pet in your waking life, these negative cultural associations are not likely to apply to you. " +
                "Some interpretations suggest that seeing a black cat in a dream always means impending danger, " +
                "while a white cat represents your strong affection for a particular person.");
        Dream dream5 = new Dream("Butterfly","The butterfly is symbolic of an intense transformation for the better and as such, it is associated with the soul and resurrection. It is sometimes thought to be an omen of death in the family. When associated with death, the dream butterfly appears to prepare the dreamer for the loss of loved one.\n" +
                "\n" +
                "The colors of the dream butterfly are important indicators of its meaning, as is its size – the bigger the butterfly, the greater impression you will make in a social situation.  " +
                "The dream butterfly suggests that you move more lightly in some endeavor and expect things to change as opportunities arise." +
                " The butterfly indicates that change is inevitable, but it does not have to be traumatic.");
        dreamList.add(dream5);
        dreamList.add(dream4);
        dreamList.add(dream);
        dreamList.add(dream3);
        dreamList.add(dream2);
        dreamList.add(dream1);







    }



}

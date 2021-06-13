package adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.HTML;
import com.example.myapplication.R;
import com.example.myapplication.RecyclerViewClickListener;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import modelclass.Home_Model;



public class Home_Adapter extends RecyclerView.Adapter<Home_Adapter.ViewHolder> implements RecyclerViewClickListener {
    public int t;
    Context context;
    private static RecyclerViewClickListener itemListener;
    ArrayList<Home_Model>home_models;
    boolean showingFirst = false;
    private ArrayList<String> pri =new ArrayList<>();
    private RecyclerViewClickListener recyclerViewOnItemClick;
public int Prodid=0;
    public Home_Adapter(Context context, HTML recyclerViewOnItemClick1, ArrayList<Home_Model> home_models) {
        this.context = context;
        this.home_models = home_models;
        this.itemListener=itemListener;
        this.recyclerViewOnItemClick = recyclerViewOnItemClick1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


         holder.name.setText(home_models.get(position).getName());
        holder.textquiz.setText(home_models.get(position).getTextquiz());
        holder.texttopic.setText(home_models.get(position).getTexttopic());
        holder.imagequiz.setImageResource(home_models.get(position).getImagequiz());
        holder.imageshose.setImageResource(home_models.get(position).getImageshose());
        holder.imagetopic.setImageResource(home_models.get(position).getImagetopic());


        holder.lvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Prodid=home_models.get(position).getProductId();
                recyclerViewOnItemClick.recyclerViewListClicked(Prodid);

            }
        });


    }

    @Override
    public int getItemCount() {
        return home_models.size();
    }

    @Override
    public void recyclerViewListClicked(int s) {
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageshose,imagequiz,imagetopic;
        TextView name,textquiz,texttopic;
        ConstraintLayout lvContainer;
       // TextView productId;
        public ViewHolder(View parent) {
            super(parent);

            imageshose = itemView.findViewById(R.id.image1);
            imagetopic=itemView.findViewById(R.id.image2);
            imagequiz = itemView.findViewById(R.id.image3);
            name = itemView.findViewById(R.id.text1);
            textquiz = itemView.findViewById(R.id.text2);
            texttopic = itemView.findViewById(R.id.text3);
            lvContainer=itemView.findViewById(R.id.lvcontainer);
        }
    }
    public int  getpos(){

        return t;
    }
    public int getProductId(){
        return Prodid;
    }
}

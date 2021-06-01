package com.example.candmasterdavidproyecto.Vacunas;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.candmasterdavidproyecto.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter <MainModel,MainAdapter.myViewHolder>{

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public MainAdapter(@NonNull FirebaseRecyclerOptions<MainModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder,final int position, @NonNull MainModel model) {
        holder.nombreperro.setText(model.getNombrevacuna());
        holder.nombrevacuna.setText(model.getNombreperro());
        holder.fecha.setText(model.getFecha());

        Glide.with(holder.img.getContext())
                .load(model.getFoto())
                .placeholder((R.drawable.vacuna))
                .circleCrop()
                .error(R.drawable.vacuna)
                .into(holder.img);

        //update
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                       .setContentHolder(new ViewHolder(R.layout.update_popup))
                        .setExpanded(true,1200)
                        .create();
               //dialogPlus.show();
                    View view = dialogPlus.getHolderView();
                EditText nombreperro = view.findViewById(R.id.txtnombreperro);
                EditText nombrevacuna = view.findViewById(R.id.txtnombrevacuna);
                EditText fecha = view.findViewById(R.id.txtFecha);


                Button btnActualizar = view.findViewById(R.id.btnUpdate);

                nombreperro.setText(model.getNombreperro());
                nombrevacuna.setText(model.getNombrevacuna());
                fecha.setText(model.getFecha());
                dialogPlus.show();

                //btnactualizar
                btnActualizar.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map  = new HashMap<>();
                        map.put("nombreperro",nombreperro.getText().toString());
                        map.put("fecha",fecha.getText().toString());
                        map.put("nombrevacuna",nombrevacuna.getText().toString());
                        FirebaseDatabase.getInstance().getReference().child("vacunas_perros_2021")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {

                                        Toast.makeText(holder.nombreperro.getContext(), "Actualizado correctamente", Toast.LENGTH_SHORT).show();
                                       dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(Exception e) {
                                        Toast.makeText(holder.nombreperro.getContext(), "Error al Actualizar", Toast.LENGTH_SHORT).show();
                                        //dialogPlus.dismiss();
                                    }
                                });



                    }
                });
            }
        });
                 holder.btnDelete.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     AlertDialog.Builder builder = new AlertDialog.Builder(holder.nombreperro.getContext());
                     builder.setTitle("¿ Estas seguro que quieres ELIMINAR ?");
                     builder.setMessage("Si se ELIMINA no se puede REHACER");

                     builder.setPositiveButton("Borrar", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                                FirebaseDatabase.getInstance().getReference().child("vacunas_perros_2021")
                                        .child(getRef(position).getKey()).removeValue();
                         }
                     });

                     builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                         @Override
                         public void onClick(DialogInterface dialog, int which) {
                             Toast.makeText(holder.nombreperro.getContext(), "Cancelado", Toast.LENGTH_SHORT).show();
                         }
                     });
                        builder.show();
                             }
                    });


    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        CircleImageView img;
        TextView nombreperro, nombrevacuna, fecha;
        Button btnEdit,btnDelete;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(CircleImageView)itemView.findViewById(R.id.img1);
            nombreperro =(TextView)itemView.findViewById(R.id.nametext);
            nombrevacuna =(TextView)itemView.findViewById(R.id.coursetext);
            fecha =(TextView)itemView.findViewById(R.id.emailtext);

            btnEdit =(Button)itemView.findViewById(R.id.btnEdit);
            btnDelete =(Button)itemView.findViewById(R.id.btnDelete);

        }
    }

}

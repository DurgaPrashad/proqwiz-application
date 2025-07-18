package com.example.proqwiz.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.proqwiz.Models.QuestionModel;
import com.example.proqwiz.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BookMarksAdapter extends RecyclerView.Adapter<BookMarksAdapter.ViewHolder> {

    List<QuestionModel> quesList;

    public BookMarksAdapter(List<QuestionModel> quesList) {
        this.quesList = quesList;
    }

    @NonNull
    @Override
    public BookMarksAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookmark_item_layout,parent,false);

        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull BookMarksAdapter.ViewHolder holder, int position) {

        String ques = quesList.get(position).getQuestion();
        String a = quesList.get(position).getOptionA();
        String b = quesList.get(position).getOptionB();
        String c = quesList.get(position).getOptionC();
        String d = quesList.get(position).getOptionD();
        int ans = quesList.get(position).getCorrectAns();

        holder.setData(position, ques,a,b,c,d,ans);
    }

    @Override
    public int getItemCount() {
        return quesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView quesNo, question, optionA, optionB, optionC, optionD, result;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            quesNo = itemView.findViewById(R.id.quesNo);
            question = itemView.findViewById(R.id.question);
            optionA = itemView.findViewById(R.id.optionA);
            optionB = itemView.findViewById(R.id.optionB);
            optionC = itemView.findViewById(R.id.optionC);
            optionD = itemView.findViewById(R.id.optionD);
            result = itemView.findViewById(R.id.result);
        }


        private void setData(int pos, String ques, String a, String b, String c, String d, int ans) {

            quesNo.setText("Question No. " + String.valueOf(pos + 1));
            question.setText(ques);
            optionA.setText("A. " + a);
            optionB.setText("B. " + b);
            optionC.setText("C. " + c);
            optionD.setText("D. " + d);


            if(ans == 1)
            {
                result.setText("ANSWER : " + a);
            }
            else if(ans == 2)
            {
                result.setText("ANSWER : " + b);
            }
            else if(ans == 3)
            {
                result.setText("ANSWER : " + c);
            }
            else
            {
                result.setText("ANSWER : " + d);
            }

        }

        }


}

package com.kiarra.homeworkroom;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.PrimaryKey;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater layoutInflater;
    private List<Word> mWords;

    WordListAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View itemView = layoutInflater.inflate(R.layout.activity_word_list_adapter, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        if(mWords !=null){
            Word current = mWords.get(position);
            holder.mTitleText.setText(current.getTitle());
            holder.mContentText.setText(current.getContent());
        } else {
            holder.mTitleText.setText(R.string.no_notes);
            holder.mContentText.setText("");
        }
    }

    @Override
    public int getItemCount() {
        if(mWords !=null){
            return mWords.size();
        }
        else {
            return 0;
        }
    }

    void setWords(List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    class WordViewHolder extends RecyclerView.ViewHolder{

        private final TextView mTitleText;
        private final TextView mContentText;

        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitleText = itemView.findViewById(R.id.titleTextView);
            mContentText = itemView.findViewById(R.id.contentTextView);
        }
    }
}

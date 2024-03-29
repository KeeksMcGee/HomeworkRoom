package com.kiarra.homeworkroom;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        mWordDao = db.wordDao();
        mAllWords = mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    public void insert(Word word){
        new InsertAsyncTask(mWordDao).execute(word);
    }

    private static class InsertAsyncTask extends AsyncTask<Word, Void, Void>{
        private WordDao mAsyncWordDao;

        InsertAsyncTask(WordDao wordDao){
            mAsyncWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(final Word... words){
            mAsyncWordDao.insert(words[0]);
            return null;
        }
    }
}

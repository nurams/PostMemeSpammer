package task.project.postmemespammer3;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentNews extends Fragment {

    View v;
    private RecyclerView recyclerView;
    private List<News> lstNews;

    public FragmentNews() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.news_fragment, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview_news);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), lstNews);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;


    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstNews = new ArrayList<>();
        lstNews.add(new News("Hotspot",R.drawable.hotspot));
        lstNews.add(new News("All Might",R.drawable.allmight));
        lstNews.add(new News("Gblk",R.drawable.gblk));
        lstNews.add(new News("Proletar vs Borjuis",R.drawable.proletarvsborjuis));
        lstNews.add(new News("Reality when you playing game",R.drawable.reality));
        lstNews.add(new News("RTX ON VS RTX OFF",R.drawable.rtxonoff));
        lstNews.add(new News("Thug Life",R.drawable.thuglife));
        lstNews.add(new News("Well Played Dude",R.drawable.wellplayed));
        lstNews.add(new News("Mom Always Right",R.drawable.womenalwaysright));
        lstNews.add(new News("Balance",R.drawable.yoga));

    }
}

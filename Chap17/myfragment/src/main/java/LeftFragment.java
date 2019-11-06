import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;

public class LeftFragment extends ListFragment {
    String[] datas;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        datas = new String[]{"2학년 4반", "2학년 5반", "2학년 6반"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,datas);
        setListAdapter(adapter);

        super.onViewCreated(view, savedInstanceState);
    }
}

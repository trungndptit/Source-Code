package com.example.sourcecode.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sourcecode.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ExampleAdapter extends BaseRecyclerViewAdapter<File, ExampleAdapter.ViewHolder> {

    List<Object> mList = new ArrayList<>();
    // muốn hiển thị và cập nhật số thứ tự khi click vào các item thì tạo 1 list ngoài
    // mỗi lần click thì add hoặc xóa
    // khi add thì set dựa vào list này
    // khi xóa thì cần gọi notifyDataSetChanged()
    // rồi nó sẽ nhảy về hàm bind,
    // lúc này so sánh xem đối tượng đang bind có nằm trong list không, nếu có thì stt là bao nhiêu.
    // lấy được stt thì truyền số ấy vào để cập nhật lại
    // Xem chi tiết tại class ImageSelectedAdapter của project Hide File tháng 6/2020


    // có thể sử dụng hàm contructor có đối số để chọn lựa layout của item trong onCreateViewHolder

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_file_select, parent, false);
        return new ViewHolder(view, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(mDataList.get(position));
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        OnItemClickListener mOnItemClickListener;

        ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener) {
            super(itemView);
            mOnItemClickListener = onItemClickListener;

        }

        void bind(final File file) {

        }
    }


}

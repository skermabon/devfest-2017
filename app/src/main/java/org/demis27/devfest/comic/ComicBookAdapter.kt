package org.demis27.devfest.comic

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.demis27.devfest.comic.model.ComicBook
import org.demis27.devfest.comic.model.ComicBookDAO

class ComicBookAdapter(var data: ComicBookDAO, context: Context) : BaseAdapter() {

    val mInflater: LayoutInflater
    init {
        mInflater = LayoutInflater.from(context);
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View?
        val vh: ListRowHolder
        view = mInflater.inflate(R.layout.row_item, parent, false)
        vh = ListRowHolder(view)
        view?.tag = vh
        vh.title.text = data.get(id = position)?.title
        vh.issue.text = data.get(id = position)?.number.toString()

        return view
    }

    override fun getItem(p0: Int): ComicBook {
        return data.get(p0) as ComicBook
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }

}

class ListRowHolder(row: View?) {
    val title: TextView
    val issue: TextView

    init {
        this.title = row?.findViewById(R.id.title) as TextView
        this.issue = row?.findViewById(R.id.issue) as TextView
    }

}
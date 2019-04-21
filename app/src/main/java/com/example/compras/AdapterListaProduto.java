package com.example.compras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListaProduto extends BaseAdapter {


    private Context context;
    private List<Produto> produtos;
    private LayoutInflater inflater;

    public AdapterListaProduto(Context context, List<Produto> produtos) {
        this.context = context;
        this.produtos = produtos;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return produtos.get(position).getIdProduto();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.layout_item_produto, null);
            item = new Suporte();

            item.tvNomeProduto = (TextView) convertView.findViewById(R.id.tvIdNomeProduto);
            item.tvQtdProduto = (TextView) convertView.findViewById(R.id.tvQuantidaeProduto);
            item.tvValorProduto = (TextView) convertView.findViewById(R.id.tvPrecoProduto);
            convertView.setTag(item);

        } else {
            item = (Suporte) convertView.getTag();
        }

        Produto prod = produtos.get(position);
        //item.tvIdProduto.setText(String.valueOf(prod.getId()));
        item.tvNomeProduto.setText(prod.getNomeProduto());
        System.out.println("Adapter: Adicionou o Nome");
        item.tvValorProduto.setText(String.valueOf(prod.getValor()));
        System.out.println("Adapter: Adicionou o Valor");
        System.out.println(prod.getValor());
        item.tvQtdProduto.setText(String.valueOf(prod.getQtdProduto()));
        System.out.println("Adapter: Adicionou a Quantidade");
        System.out.println(prod.getQtdProduto());


        return convertView;
    }

    private class Suporte {
        TextView tvNomeProduto, tvQtdProduto, tvValorProduto;
    }

}

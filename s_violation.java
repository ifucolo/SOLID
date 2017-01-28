public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.ViewHolder> {

    private ArrayList<IntervalDataBase> dataBases;
    private Context context;
    public BudgetAdapter(ArrayList<IntervalDataBase> dataBases, Context context) {
        this.dataBases = dataBases;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent,false);;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        IntervalDataBase intervalDataBase = dataBases.get(position);
        String date = "";
        
        if (intervalDataBase.date != null) {
            String[] split = dataBases.get(position).date.split("-");
            date = split[1] + " " + Util.getMonthLittle(Integer.parseInt(split[0]));
        }

        holder.date.setText(date);
        holder.name.setText(intervalDataBase.description);
        holder.value.setText(context.getString(R.string.money, String.valueOf(intervalDataBase.amount)));
    }

    @Override
    public int getItemCount() {
        return dataBases.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.layout)
        LinearLayout layout;

        @BindView(R.id.date)
        TextView date;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.value)
        TextView value;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}

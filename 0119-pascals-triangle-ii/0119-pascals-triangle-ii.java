class Solution {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer>prev=new ArrayList<>();
        prev.add(1);
        if(rowIndex==0)return prev;
        for(int i=1;i<=rowIndex;i++){
            ArrayList<Integer>current=new ArrayList<>();
            current.add(1);
            for(int j=1;j<prev.size();j++){
                current.add(prev.get(j-1)+prev.get(j));
            }
            current.add(1);
            prev=current;
        }
        return prev;
    }
}
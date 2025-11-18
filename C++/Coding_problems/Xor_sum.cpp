#include <iostream>
#include <vector>
using namespace std;

int main() {
    int n,q;
    cin>>n>>q;
    vector<int> a(n+1),prefix(n+1,0);
    vector<vector<int>> queries;
    for(int i=1;i<=n;i++){
        cin>>a[i];
        prefix[i]=prefix[i-1]^a[i];
    }
    for(int i=0;i<q;i++){
        int l,r;
        cin>>l>>r;
        queries.push_back({l,r});
    }
    for(int i=0;i<q;i++){
        int l=queries[i][0];
        int r=queries[i][1];
        int res=prefix[r]^prefix[l-1];
        cout<<res<<endl;
    }
    return 0;
}
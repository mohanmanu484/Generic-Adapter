# Generic-Adapter
One recycler view adapter for all your project

 1.enable databinding in your app gradle 
 
     dataBinding{
         enabled true
     }
 
2. Add dependency 
 
        compile 'com.mohanmanu.genericadapter:genericadapter:1.0'
 
3. Add attributes for your recycler view 


    <layout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto">
    
        <data>
    
            <variable
                name="list"
                type="android.databinding.ObservableList" />
        </data>
    
    
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
    
            <android.support.v7.widget.RecyclerView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:genericLayout="@{@layout/adapter_single_view_type}"
                app:listItem="@{list}" />
    
        </LinearLayout>
    
    </layout>
    
  provide observable list from your fragment or activity or viewmodel
  
  say you  are  having fragment called SingleViewTypeFragment
  
      public class SingleViewTypeFragment extends Fragment {
  
           public ObservableList<String> observableList=new ObservableArrayList<>();
  
  
      @Nullable
      @Override
      public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
  
          FragmentSingleViewtypeBinding fragmentSingleViewtypeBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_single_viewtype,container,false);
          fragmentSingleViewtypeBinding.setList(observableList);
          observableList.add("test string");
          return fragmentSingleViewtypeBinding.getRoot();
      }
  
     }
   
    
  4. write adapter items layout
  
  
     <?xml version="1.0" encoding="utf-8"?>
     <layout xmlns:android="http://schemas.android.com/apk/res/android"
      xmlns:tools="http://schemas.android.com/tools">
  
      <data>
  
          <variable
              name="item"
              type="String" />
      </data>
  
      <LinearLayout
          android:layout_width="match_parent"
          android:layout_height="wrap_content"
          android:orientation="vertical">
  
          <TextView
              android:layout_width="match_parent"
              android:layout_height="wrap_content"
              android:padding="@dimen/dimen_16"
              android:text="@{item}"
              tools:text="single view type" />
  
      </LinearLayout>
     </layout>
            
  thats it you are done no need to write adapter everytime you create a new list
  
  
  5. To handle Onclick events add one more attribute to recycler view
  
  example
  
     <layout xmlns:android="http://schemas.android.com/apk/res/android"
       xmlns:tools="http://schemas.android.com/tools"
       xmlns:app="http://schemas.android.com/apk/res-auto">
   
       <data>
           <variable
               name="list"
               type="android.databinding.ObservableList"/>
           <variable
               name="viewListener"
               type="com.mohang.genericadapter.ViewListener"/>
       </data>
   
       <LinearLayout
           android:orientation="vertical" android:layout_width="match_parent"
           android:layout_height="match_parent">
           <android.support.v7.widget.RecyclerView
   
               app:viewListener="@{viewListener}"
               app:genericLayout="@{@layout/adapter_single_view_type}"
               app:listItem="@{list}"
               android:layout_width="match_parent"
               android:layout_height="match_parent"
               />
   
       </LinearLayout>
     </layout>
  
  in the above code snippet it is expecting a variable of type viewListener so provide the implementation
  for the viewListener in your activity or fragment or viewModel
  
  
    public class ViewClickListenerFragment extends Fragment {
  
      public ObservableList observableList=new ObservableArrayList();
  
      @Nullable
      @Override
      public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
  
          FragmentViewListenerBinding fragmentSingleViewtypeBinding= DataBindingUtil.inflate(inflater,R.layout.fragment_view_listener,container,false);
          fragmentSingleViewtypeBinding.setList(observableList);
          observableList.addAll(DataSource.getListOfNUmbers());
          fragmentSingleViewtypeBinding.setViewListener(viewListener);
          return fragmentSingleViewtypeBinding.getRoot();
      }
  
      public ViewListener viewListener=new ViewListener() {
          @Override
          public void onClick(View v, int pos, Object object) {
  
              Toast.makeText(getActivity(), "item @ pos "+pos+" is "+((String)object), Toast.LENGTH_SHORT).show();
          }
      };
    }
  
  
  Thats how we can handle onClick event on an adapter
  
  
  6. So next how to handle situation when I'm having multiple viewTypes?
     so that can also be handled by adding one more attribute called viewTypeListener
     
     
    <variable
                 name="viewTypeHandler"
                 type="com.mohang.genericadapter.ViewTypeHandler"/>
  
   provide variable of type ViewTypeHandler in your recyclerview
   
   then write the ViewType handler in your view , based on the position or object that you are getting 
   you can return different layout that you want to inflate 
   
     
      ViewTypeHandler viewTypeHandler=new ViewTypeHandler() {
             @Override
             public int getViewType(int pos, Object item) {
                 if(item instanceof Car){
                     return R.layout.adapter_car_view_type;
                 }
                 return R.layout.adapter_bus_view_type;
             }
         };
         
   and add it onto recycler view 
    
    <android.support.v7.widget.RecyclerView
              android:layout_width="match_parent"
              android:layout_height="match_parent"
              app:viewTypeHandler="@{viewTypeHandler}"
              app:listItem="@{list}" />
  
  
  
  
  
  7. for more complex cases like gridlayout adapter ,and handling onclicks 
  for different views on a same layout please refer to the examples given
  
  8. Rules of adapter items
  
    <data>
          
           <variable
                   name="item"
                   type="String" />
           <variable
                   name="pos"
                   type="Integer" />
           <variable
                   name="actionHandler"
                   type="your handler class which imlements ActionHandler" />
     </data>
 
 
   your adapter item should always use the same variable to work
   
   
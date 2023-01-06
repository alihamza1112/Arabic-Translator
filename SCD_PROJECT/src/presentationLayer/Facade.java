package presentationLayer;

import java.sql.SQLException;

public class Facade {
	private ImportFileView importFileFrame;
	private AddMeaningView meaningViewFrame;
	private RootView rootViewFrame;
	private SearchDataView searchDataViewFrame;
	
	public void openImportFileFile() {
		importFileFrame =new ImportFileView();
		importFileFrame.setVisible(true);
	}
	public void openMeaningViewFrame() {
		try {
			meaningViewFrame =new AddMeaningView();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meaningViewFrame.setVisible(true);
	}
	public void openRootViewFrame() {
		try {
			rootViewFrame =new RootView();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rootViewFrame.setVisible(true);
	}
	public void openSearchDataViewFrame() {
		searchDataViewFrame =new SearchDataView();
		searchDataViewFrame.setVisible(true);
	}
}

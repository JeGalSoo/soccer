import { GridColDef } from "@mui/x-data-grid";

export default function Columns(): GridColDef[]{
    return [
        {
            flex:0.04,
            minWidth: 30,
            sortable: false,
            field: 'id',
            headerName: 'ID',
            renderCell(){
                return<></>
            }
        },
        {
            flex:0.04,
            minWidth: 30,
            sortable: false,
            field: 'title',
            headerName: 'TITLE',
            renderCell(){
                return<></>
            }
        },
        {
            flex:0.04,
            minWidth: 30,
            sortable: false,
            field: 'content',
            headerName: 'CONTENT',
            renderCell(){
                return<></>
            }
        },
        {
            flex:0.04,
            minWidth: 30,
            sortable: false,
            field: 'registerDate',
            headerName: 'REGISTERDATE',
            renderCell(){
                return<></>
            }
        }
    ]
}
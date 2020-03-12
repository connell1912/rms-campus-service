import React from "react";
import { IStatus } from "./IStatus"; //Need to change this when it's brought over
import { Table, TableHead, TableBody, TableRow, TableCell } from "reactstrap";

interface IStatusProps {
  allStatuses: IStatus;
}

export class RoomStatusTable extends React.PureComponent<IStatusProps> {
  render() {
    return (
      <>
        <Table>
          <TableHead>
            <TableRow>
              <TableCell>Whiteboard cleaned?</TableCell>
              <TableCell>Ordered?</TableCell>
              <TableCell>Desks cleaned?</TableCell>
              <TableCell>Submitted</TableCell>
              <TableCell>Submitter</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            <TableRow>
              <TableCell>status.whiteboardCleaned</TableCell>
              <TableCell>status.chairOrdered</TableCell>
              <TableCell>status.desksCleaned</TableCell>
              <TableCell>status.submittedDateTime</TableCell>
              <TableCell>status.submitter</TableCell>
            </TableRow>
          </TableBody>
        </Table>
      </>
    );
  }
}

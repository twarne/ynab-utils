package com.kickthedrawer.ynab.amazon;

import com.kickthedrawer.ynab.amazon.persistence.model.Order;
import com.kickthedrawer.ynab.amazon.persistence.model.Refund;
import com.kickthedrawer.ynab.amazon.persistence.model.ReportItem;
import com.kickthedrawer.ynab.amazon.persistence.model.Shipment;

public enum ReportType {
    ORDER(Order.class),
    SHIPMENT(Shipment.class),
     REFUND(Refund.class);

    private Class<? extends ReportItem> type;

    private ReportType(Class<? extends ReportItem> type) {
        this.type = type;
    }

    public Class<? extends ReportItem> getType() {
        return type;
    }
    
}

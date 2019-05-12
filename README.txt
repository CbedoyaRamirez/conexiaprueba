while (itr.hasNext()) {
            Object[] obj = (Object[]) itr.next();
            HistoricoReportesSiplaft historicoInd = new HistoricoReportesSiplaft();
            historicoInd.setRadicado(Long.parseLong(obj[0].toString()));
            historicoInd.setNit(Double.parseDouble(obj[1].toString()));
            historicoInd.setContrato(obj[2].toString());
            historicoInd.setReporte(obj[3].toString());
            historicoInd.setCantRegCorrectos(Double.parseDouble(obj[4].toString()));
            historicoInd.setFechaRecepcion(sdf.parse(obj[5].toString()));
            historicoInd.setFechaReporte(sdf.parse(obj[6].toString()));
            retorno.add(historicoInd);
        }